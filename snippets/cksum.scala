import ChecksumAccumulator.calculate

object CkSum extends App {
  args.foreach(s => println(s"$s: ${calculate(s)}"))
}
