# Java Numpy Interface

This library saves and load numpy npy format in Java. Here is the format to save and load Java arrays into numpy:

```
int[] array = {1, 2, 3, 4, 5, 6};
NumpyArray np = new NumpyArray(array);
np.save("/path/to/a/file.npy");

array = (int[])NumpyArray.load("/path/to/an/npy/file.npy");
```

This library is purely implemented in Java and does not have any dependencies! Just copy the code and enjoy.

## Compatibility

This library uses numpy version 1.0 specification. The specification for this format is explained in:

[A Simple File Format for NumPy Arrays](https://numpy.org/neps/nep-0001-npy-format.html)

## Code Structure

### NumpyArray

NumpyArray is the main class that handles the format for numpy arrays. You can both serialize and deserialize arrays using the ```load```and ```save``` methods provided. Note that both these methods accepts a string path (for local files) and stream (for other types of media).

### IArrayWrapper

The library currently supports the following types:
- ```byte[]...[]``` 
- ```short[]...[]``` 
- ```int[]...[]``` 
- ```float[]...[]``` 
- ```double[]...[]```

Each one of these types is handled by a class that implements ```IArrayWrapper```. The NumpyArray class is thus immune to future changes that will be done to additional formats. Note that since Java does not support unsigned numbers, saving unsigned numbers is impossible and loading them will most likely fail.

** IMPORTANT Note ** If you decide to add a new type of IArrayWrapper, let's say for ArrayList<Double>, you need to register it in ```ArrayWrappers``` or it will be ignored by the library. 

 
