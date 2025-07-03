# historic-tech

## Install LISP

```shell
apt-get install sbcl
apt-get install rlwrap
apt-get install cl-quicklisp
```

```common lisp
(load "/usr/share/common-lisp/source/quicklisp/quicklisp.lisp")
(quicklisp-quickstart:install)
(ql:quickload '("str" "cl-ppcre" "alexandria", "cl-project", "rove"))
(ql:quickload "str")
(ql:quickload "cl-project")
(ql:quickload "rove")
```

## After install

```common lisp
(ql:quickload "str")
(ql:quickload "cl-project")
(ql:quickload "rove")
```

## Project creation

```common lisp
(require "asdf")
(load (merge-pathnames "~/quicklisp/setup.lisp" (uiop:getcwd)))
(ql:quickload '("str" "cl-ppcre" "alexandria" "cl-project" "rove"))
(cl-project:make-project #P"./tailrec-lisp")
(in-package :tailrec-lisp)
(asdf:test-system :tailrec-lisp)
(pushnew "./tailrec-lisp" asdf:*central-registry* :test #'equal)
(setf *print-case* :downcase)
(require "asdf")
(asdf:load-asd (merge-pathnames "tailrec-lisp.asd" (uiop:getcwd)))
```

## Loading

```common lisp
(require "asdf")
(load (merge-pathnames "~/quicklisp/setup.lisp" (uiop:getcwd)))
(ql:quickload '("str" "cl-ppcre" "alexandria" "cl-project" "rove"))
(asdf:load-asd (merge-pathnames "tailrec-lisp.asd" (uiop:getcwd)))
(asdf:load-system :tailrec-lisp)
(asdf:test-system :tailrec-lisp)
(tailrec-lisp:two-power-of 3)
(format t "Factorial of 5 is ~a" (tailrec-lisp:factorial 5))
(format t "Factorial of 5 is ~a" (tailrec-lisp:factorial-iter 5))
(format t "Fibonacci of 100 is ~a" (tailrec-lisp:fibonacci-iterative 100))
(quit)
```

## Others

```common lisp
(load "/home/jesperancinha/quicklisp/setup.lisp")
(asdf:load-asd #P"./tailrec-lisp.asd")
```

## Exiting

The best way to quit the `sbcl` console is to simply press Ctr-C at any point and just evaluate `(quit)` wherever that lands you.

## Resources

-   [The Common Lisp Cookbook – Getting started with Common Lisp](https://lispcookbook.github.io/cl-cookbook/getting-started.html)

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
