import java.util.ArrayList;

public class Variable {

    public Column[] createVariable(int variables, ArrayList<String> prep) {

        int rows = (int) Math.pow(2,variables);
        Column[] table = new Column[variables];
        for (int x = 0; x< variables; x++){
            table[x] = new Column(prep.get(x));
        }
        for (int i=0; i<rows; i++) {
            for (int j=variables-1; j>=0; j--) {
                boolean entry;
                int calc = (i/(int) Math.pow(2, j))%2;
                if (calc == 1){
                    entry = true;
                }else {
                    entry = false;
                }
                table[variables-1 - j%variables].addRowValue(entry);
            }
        }
        return table;
    }
    public Column and(Column c2, Column c1){
        String name = c1.getName() +"&" +c2.getName();
        Column result = new Column(name);
        for (int i = 0; i<c1.getSize(); i++){
            boolean value = c1.getRowValue(i) && c2.getRowValue(i);
            result.addRowValue(value);
        }
        return result;
    }
    public Column or(Column c2, Column c1) {
        String name = c1.getName() + "||" + c2.getName();
        Column result = new Column(name);
        for (int i = 0; i < c1.getSize(); i++) {
            boolean value = c1.getRowValue(i) || c2.getRowValue(i);
            result.addRowValue(value);
        }
        return result;
    }
    public Column xor(Column c2, Column c1){
        String name = c1.getName() + "^" + c2.getName();
        Column result = new Column(name);
        for (int i = 0; i < c1.getSize(); i++) {
            boolean value = (c1.getRowValue(i) && (!c2.getRowValue(i))) || ((!c1.getRowValue(i)) && c2.getRowValue(i));
            result.addRowValue(value);
        }
        return result;
    }
    public Column not(Column c1) {
        String name = "!"+c1.getName() ;
        Column result = new Column(name);
        for (int i = 0; i < c1.getSize(); i++) {
            boolean value = !c1.getRowValue(i);
            result.addRowValue(value);
        }
        return result;
    }

}
