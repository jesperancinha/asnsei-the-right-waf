(defpackage tailrec-lisp/tests/main
  (:use :cl
        :tailrec-lisp
        :rove))
(in-package :tailrec-lisp/tests/main)

;; NOTE: To run this test file, execute `(asdf:test-system :tailrec-lisp)' in your Lisp.

(deftest test-target-1
  (testing "should (= 1 1) to be true"
    (ok (= 1 1))))
