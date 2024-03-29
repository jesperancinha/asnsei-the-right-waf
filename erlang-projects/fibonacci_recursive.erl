-module(fibonacci_recursive).
-export([fib/1]).

fib(0) -> 0;
fib(1) -> 1;
fib(N) when N > 1 ->
    fib(N - 1) + fib(N - 2).
