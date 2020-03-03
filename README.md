# Java Numpy Interface

This library saves and load numpy npy format in Java. Here is the format to save and load Java arrays into numpy:

```
int[] array = {1, 2, 3, 4, 5, 6};
NumpyArray np = new NumpyArray(array);
np.save("/path/to/a/file.npy");

array = (int[])NumpyArray.load("/path/to/an/npy/file.npy");
```

## Compatibility

This library uses numpy version 1.0 specification. The specification for this format is explained in:

[A Simple File Format for NumPy Arrays](https://numpy.org/neps/nep-0001-npy-format.html)

## Code Documentation

I've made video on YouTube that explains the code. Please feel free to watch it and change the code if needed.

[Code Video Document]()

 