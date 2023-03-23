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
object sortingActor {

}
