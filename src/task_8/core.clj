(ns task-8.core
  (:require [task-8.class_declaration :refer :all])
  (:gen-class))

(use 'clojure.set)
(use 'clojure.repl)

;; This is for pretty printing of ::keywords.
;; TODO (delete when read, please) If you perform (println ::keyword) without this code the output
;; TODO (delete when read, please) will be ":task-8.core/keyword" instead of just "::keyword".
(import 'clojure.lang.Keyword)
(import 'java.io.Writer)
(defmethod print-method
  Keyword [^Keyword k, ^Writer w]
  (if (.getNamespace k)
    (.write w (str "::" (name k)))
    (.write w (str k))))


;(def-class :B0 ()
;  (:cnt1 :cnt2 :cnt3))
;
;(def-class :B1 ()
;  (:cnt :fld1 :fld2)
;  (attr-accessor :cnt)
;  (attr-reader :fld1 :fld2)
;  (attr-writer :fld2)
;  (init :cnt 42
;        :fld1 "Test"
;        :fld2 (list 1 2 3)))
;
;(def-class :D0 (:B0)
;  (:cnt1 :cntD1))
;
;(def-class :DD (:D0 :B1)
;  (:cnt5)
;  (init :cnt5 1
;        :fld2 `(4 5 6)))
;
(defn -main []
;  (def q (new-instance :B0 :cnt1 "1" :cnt2 '(2) :cnt3 3))
;  (def q (new-instance :B1 :cnt 1 :fld2 '(2) :fld1 "Test2"))
;  (def e (new-instance :DD :cntD1 1 :cnt1 3 :fld1 "Test3" :cnt 2 :cnt2 1 :cnt5 32 :cnt3 5))
  
 ; (println (get-cnt e))
 ; (println (get-cnt q))
 ; (println (get-fld1 e))

;  (set-cnt e 6)
 ; (println (get-cnt e))

;  (set-fld2 q `(1 5 10))
 ; (println (get-fld2 q))

;  (println q)
;  (println (instance-class q))

;  (println (is-instance? q))
;  (println (is-instance? [1 2]))
;  (println (getf q :cnt2))
;  (setf q :cnt2 '(3))
;  (println (getf q :cnt2))
;
;  (def-generic increment-cnt)
;  (def-method increment-cnt :Base [obj amount amount2]
;    (setf obj :cnt3 (+ amount (getf obj :cnt3))))

;  (increment-cnt q 3 5)
;  (println q "\n")

;  (def w (create-instance :Derived :cnt1 "1" :cnt2 '(2) :cnt4 4 :cnt3 3))
;  (println w)
;  (def-method increment-cnt :Derived [obj amount amount2]
;    (super amount amount2)
;    (setf obj :cnt4 (+ amount (getf obj :cnt4))))

;  (println)
;  (println w)
;  (increment-cnt w 5 7)
;  (println w)
;
;  (def-method increment-cnt :Derived_from_Derived [obj amount amount2]
;    (super amount amount2)
;    (setf obj :cnt5 (+ amount2 (getf obj :cnt5))))

;  (println)
;  (println e)
;  (increment-cnt e 5 7)
;  (println e)

;  (println)
;  (println @classes-hierarchy)



 ; (Thread/sleep 1000)
  ;(dotimes [i 10] (.start (Thread. (fn [] (mac i) (Thread/sleep (* 1000 i))  ))))

  ;(Thread/sleep 1000)

  (def-class :A () ())
  (def-class :B (:A) ())
  (def-class :C (:A) ())
  (def-class :D (:A) ())
  (def-class :E (:B :C) ())
  (def-class :F (:D) ())
  (def-class :G (:D) ())
  (def-class :H (:E :F :G) ()) ; BFS = ({:H} {:E :F :G} {:B :C :D} {:A}), {..} means a common tree level.

  (def e (new-instance :H))

  (def-generic classes-names)
  (def-method classes-names :A [obj] (println :A)) 
  (def-method classes-names :B [obj] (call_next_method) (println :B))
  (def-method classes-names :C [obj] (println :C) (call_next_method))
  (def-method classes-names :D [obj] (println :D) (call_next_method))
  (def-method classes-names :E [obj] (println :E) (call_next_method))
  (def-method classes-names :F [obj] (println :F) (call_next_method))
  (def-method classes-names :G [obj] (println :G) (call_next_method))
  (def-method classes-names :H [obj] (println :H) (call_next_method))
                           ; [(:H obj1) (:J obj2) arg1 arg2 ... argN]  
  (classes-names e)


  (println "\nThe End."))





