package numpy;

public interface IArrayWrapper {
    int size();
    boolean isArrayOfArray();
    Object get(int index);
    boolean supportType(Object data);
    IArrayWrapper createInstance(Object data);
}
