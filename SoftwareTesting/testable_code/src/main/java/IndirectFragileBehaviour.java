import utils.Number;

public class IndirectFragileBehaviour {
    public void setSquared(Number n, int v){
        // Bilerek burada bir kusur ekledik, aslında v*v olmalı gerekirdi.
        n.setVal(v+v);
    }

    public void setSquaredFragile(Number n, int v){
        n.setSquared(v);
    }

    //Yeniden düzenleme, bir return değeri ekledik ki bu değeri test edebilelim
    public int setSquaredRefactored(Number n, int v){
        int ret = v*v;
        n.setVal(ret);
        return ret;
    }
}
