# Summary

This projects implements an algorithm that chooses customers to serve in a way that minimizes the average wait time of customers with different order processing times.

# Requirements

- Java 8
- [SBT 0.13.15](http://www.scala-sbt.org/)

# Instructions

This instructions assume that you are using a *nix OS.

- Clone the project: `git cone https://github.com/shafiquejamal/pizza.git`. I will assume that you cloned it into `/path/to/repo`
- `cd` into `/path/to/repo`
- start SBT by entering the command `sbt`. You should then be at the SBT prompt
- enter the command `test` to run the tests
- to run the program, enter the command `run /path/to/inputFile`

After the program is finished executing, it will output the average wait time.

# Assumptions

- the optimal algorithm is one that always servers next the visible, unserved customer with the shortest order processing time.
- the input file exists and is well-formed. The format is:

```
text that is ignored
arrival_time order_processing_time 
arrival_time order_processing_time
... 
arrival_time order_processing_time
```
Arrival times and order processing times are numeric and separated by whitespace. An example input file is:
```
the first line is ignored
0 3
1 9
2 6
```

