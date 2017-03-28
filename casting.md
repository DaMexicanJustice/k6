# K6
## Group members
Patrick Johansen, Joachim Christensen
## Subject
Type Casting
## What is casting?
In programming casting is the action of converting a datatype into a different datatype. In particular for Java we distinguish
between primitive datatype casting and non-primitive datatype casting. However in Kotlin all datatypes are objects as thus non-primitive. 
In Kotlin, everything is an object in the sense that we can call member functions and properties on any variable. 
Some types are built-in, because their implementation is optimized, but to the user they look like ordinary classes.
## Applications of type casting
It is probably impossible to avoid having to deal with type mismatches when working with software development. 
Sometimes we need to display text to the user or to developers when debugging, when doing so we may need to cast the type of a value
into something printable i.e a string. 
Depending on how a programming language handles type casting, it may or may not be necessary to be explicit about the context. 
Kotlin however, eliminates the need for explicit type casting in most cases.
### Explicit casting
Explicit casting refers to the compiler's ability of inference. 
Inference is when a data type has been presumed/assumed by the interpretor by a previous statement. 
This is possible when a variable is evaluated for type by for instance if conditionals. There is no further need to be implicit about
the data type moving forward. 
### Implicit casting
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

![image](http://i68.tinypic.com/n63vk9.png)
  
### Safe vs. Unsafe
If there is a risk of raising an exception when attempting to type cast, it is considered an unsafe cast. The opposite being a safe cast.
Unsafe casts are done by using the as keyword, as an example:

![image](http://i66.tinypic.com/14o68lg.png)

### Handling null
The ? character indicates nullables. Note that non-nullable types cannot be casted and will raise an exception.
If y was null in the below example an exception would be thrown without nullables. To mimic Java semantics all we have to do is declare nullables using '?' as such:

`val x: String? = y as? String`
