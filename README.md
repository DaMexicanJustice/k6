# K6
## Group members
Patrick Johansen, Joachim Christensen
## Type checking
### What are type checks?
The process of verifying and enforcing the constraints of types—type checking—may occur either at compile-time (a static check) or at run-time. If a language specification requires its typing rules strongly (i.e., more or less allowing only those automatic type conversions that do not lose information), one can refer to the process as strongly typed, if not, as weakly typed. The terms are not usually used in a strict sense.

### What is static type checking?
Static type checking is the process of verifying the type safety of a program based on analysis of a program's text (source code). If a program passes a static type checker, then the program is guaranteed to satisfy some set of type safety properties for all possible inputs.
Static type checking operates on program text. This allows detecting many bugs early in a development cycle, via fail-fast processes.
Static type checking can be considered a limited form of program verification (see type safety), and in a type-safe language, can be considered also an optimization. If a compiler can prove that a program is well-typed, then it does not need to emit dynamic safety checks, allowing the resulting compiled binary to run faster and to be smaller.
### What is dynamic type checking?
Dynamic type checking is the process of verifying the type safety of a program at runtime. Implementations of dynamically type-checked languages generally associate each runtime object with a type tag (i.e., a reference to a type) containing its type information. This runtime type information (RTTI) can also be used to implement dynamic dispatch, late binding, downcasting, reflection, and similar features.
Most type-safe languages include some form of dynamic type checking, even if they also have a static type checker. The reason for this is that many useful features or properties are difficult or impossible to verify statically. For example, suppose that a program defines two types, A and B, where B is a subtype of A. If the program tries to convert a value of type A to type B, which is known as downcasting, then the operation is legal only if the value being converted is actually a value of type B. Thus, a dynamic check is needed to verify that the operation is safe. This requirement is one of the criticisms of downcasting.
By definition, dynamic type checking may cause a program to fail at runtime. In some programming languages, it is possible to anticipate and recover from these failures. In others, type-checking errors are considered fatal.
### What is strong and weak typing?
In computer programming, programming languages are often colloquially classified as strongly typed or weakly typed (loosely typed). These terms do not have a precise definition, but in general, a strongly typed language is more likely to generate an error or refuse to compile if the argument passed to a function does not closely match the expected type. On the other hand, a weakly typed language may produce unpredictable results or may perform implicit type conversion.
### How can they be performed using kotlin?
#### Wildcards
Using wildcards we can determine if something is of type map. Say for instance we have a Map<String, Any?> that takes at least a string as well as any data type. If we wanted to evaluate that map variable using if-conditionals, we would need to use wildcards. This is because the check is done at run-time where there is no information about the data types.

`if (value is Map<*, *>) {...}`

#### The is keyword
Using if-conditionals in conjunction with the is keyword, we can determine the type of an argument. It enables us to determine how to proceed with our programming logic/flow. We can for instance handle unexpected types and raise errors, or alerts as needed.
![image](http://i63.tinypic.com/28vx7p3.png)

## Type casting
### What is casting?
In programming casting is the action of converting a datatype into a different datatype. In particular for Java we distinguish
between primitive datatype casting and non-primitive datatype casting. However in Kotlin all datatypes are objects as thus non-primitive. 
In Kotlin, everything is an object in the sense that we can call member functions and properties on any variable. 
Some types are built-in, because their implementation is optimized, but to the user they look like ordinary classes.
### Applications of type casting
It is probably impossible to avoid having to deal with type mismatches when working with software development. 
Sometimes we need to display text to the user or to developers when debugging, when doing so we may need to cast the type of a value
into something printable i.e a string. 
Depending on how a programming language handles type casting, it may or may not be necessary to be explicit about the context. 
Kotlin however, eliminates the need for explicit type casting in most cases.
#### Explicit casting
Explicit casting refers to the compiler's ability of inference. 
Inference is when a data type has been presumed/assumed by the interpretor by a previous statement. 
This is possible when a variable is evaluated for type by for instance if conditionals. There is no further need to be implicit about
the data type moving forward. 
#### Implicit casting
The opposite of explicit casting. Data types need to be expressed whereever applicable, because no inference is taking place. 
### Smart casts
The reason Kotlin has explicit casting is because the compiler tracks is-checks for immutable values (and behind the scenes) safe casts automatically.
Here is an example of explicit casting using [smart cast](https://kotlinlang.org/docs/reference/typecasts.html):

![image](http://i64.tinypic.com/14wyjj7.png)

It is worth mentioning that smart casts are not limited to if conditionals, but that they apply to when-expressions and while-loops as well:

![image](http://i65.tinypic.com/2vaflly.png)

For every iteration we evaluate the type of x and execute the appropriate response. 

#### Limitations
There are requiresites for smart casts. The compiler cannot smart cast when it cannot ensure that a value will change between check and usage. 
Furthermore, smart casts are possible when working with:
1. Val local variables
2. Val properties
3. Var local variables. Not captured in a lambda and not modified between check and usage *

Smart casts are not possible when working with:
4. Var properties. They can be changed by any code.

* An example of limitation #3 is:

![image](http://i68.tinypic.com/iym13m.png)
  
### Safe vs. Unsafe
If there is a risk of raising an exception when attempting to type cast, it is considered an unsafe cast. The opposite being a safe cast.
Unsafe casts are done by using the as keyword, as an example:

![image](http://i66.tinypic.com/14o68lg.png)

### Handling null
The ? character indicates nullables. Note that non-nullable types cannot be casted and will raise an exception.
If y was null in the below example an exception would be thrown without nullables. To mimic Java semantics all we have to do is declare nullables using '?' as such:

`val x: String? = y as? String`
