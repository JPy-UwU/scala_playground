object multipleErrorHandlingADT {
  case class Errors[+A](get: Seq[A]) extends Partial[A, Nothing]
  case class Success[+B](get: B) extends Partial[Nothing, B]
  sealed trait Partial[+A, +B]
  {
    def map[C](f: B => C): Partial[A, C] = this match {
      case Errors(a) => Errors(a)
      case Success(b) => Success(f(b))
    }

    def flatMap[AA >: A, C](f: B => Partial[AA, C]): Partial[AA, C] = this match {
      case Errors(a) => Errors(a)
      case Success(b) => f(b)
    }

    def getOrElse[BB >: B](default: => BB): BB = this match {
      case Errors(_) => default
      case Success(b) => b
    }

    def orElse[AA >: A, BB >: B](default: => Partial[AA, BB]): Partial[AA, BB] = this match {
      case Errors(_) => default
      case Success(b) => Success(b)
    }
  }

  object Partial {
    def map2[A, B, C](pa: Partial[A, B], pb: Partial[A, C])(f: (B, C) => A): Partial[A, (B, C)] = (pa, pb) match {
      case (Errors(a1), Errors(a2)) => Errors(a1 ++ a2)
      case (Errors(a), _) => Errors(a)
      case (_, Errors(a)) => Errors(a)
      case (Success(b), Success(c)) => Success((b, c))
    }

    def traverse[A, B](as: List[B])(f: B => Partial[A, B]): Partial[A, List[B]] =
      as.foldRight[Partial[A, List[B]]](Success(Nil))((b, a) => f(b) match {
        case Errors(errors) => Errors(errors)
        case Success(value) => a.map(values => value :: values)
      })

    def Try[A](a: => A): Partial[Throwable, A] = {
      try Success(a)
      catch {
        case e: Throwable => Errors(Seq(e))
      }
    }
  }

  def main(args: Array[String]): Unit = {

  }
}