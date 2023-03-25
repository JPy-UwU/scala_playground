/**
 * Sorting. It is possible to sort a number of values using a pipeline of filter actors,
 * each responsible for one value: the first actor picks the smallest value, the second the second smallest and so on.
 * Particularly, the first actor receives all the values, one by one.
 * If there are more than one values received by an actor, it creates another actor;
 * it keeps the smallest value received so far for itself, and sends all other values forward to the actor it created.
 * Each filter actor does the same thing.
 * Assume that each filter actor has local storage for only two of the values to be sorted:
 * the next incoming value and the minimum value seen thus far.
 */

import akka.actor._

object sortingActor {
  case class FilterActor(nextActor: ActorRef, minValue: Int, maxValue: Int) extends Actor {
    var nextValue: Option[Int] = None
    var minSaved: Int = minValue

    def receive: PartialFunction[Any, Unit] = {
      case value: Int =>
        if (value < minSaved) {
          nextValue.foreach(nextActor ! _)      // send all previously received values to the next actor
          nextValue = Some(minSaved)             // store the current minimum value as the next value
          minSaved = value                       // update the minimum value seen so far
        }
        else {
          nextValue.foreach(nextActor ! _)      // send the next value to the next actor
          nextValue = Some(value)
        }

      case 0 =>
        nextValue.foreach(nextActor ! _)        // send the next value to the next actor
        sender() ! minSaved                      // send the minimum value seen to the sender of the sentinel
    }
  }

  case class SortActor(originalSender: ActorRef) extends Actor {
    val firstActor = context.actorOf(Props(FilterActor(self, 0, Int.MaxValue)))

    def receive: PartialFunction[Any, Unit] = {
      case sorted: Int =>
        originalSender ! sorted             // send the sorted value to the original requester

      case value: Int =>
        firstActor ! value                  // send the value to the first filter actor

      case 0 =>
        firstActor ! 0                      // send the sentinel to the first filter actor
    }
  }

  class OriginalSenderActor extends Actor {
    def receive: PartialFunction[Any, Unit] = {
      case value: Int =>
        println(value)
    }
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("sortingActor")

    val originalSender = system.actorOf(Props[OriginalSenderActor])
    val sortActor = system.actorOf(Props(SortActor(originalSender)))

    sortActor ! 1
    sortActor ! 4
    sortActor ! 1
    sortActor ! 5
    sortActor ! 9
    sortActor ! 2
    sortActor ! 6
    sortActor ! 0

    system.terminate();
  }
}