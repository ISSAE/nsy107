/**
  * Récupération des champs d'une classe
  */
public class SomeClass {

    private String aaa;
    private Date date;
    private double ccc;:
    public int notPrivate;

    public static void main(String[] args) {
        List<Field> fields = getPrivateFields(SomeClass.class);
        for(Field field: fields){
            System.out.println(field.getName());
        }
    }

    public static List<Field> getPrivateFields(Class<?> theClass){
        List<Field> privateFields = new ArrayList<Field>();

        Field[] fields = theClass.getDeclaredFields();

        for(Field field:fields){
            if(Modifier.isPrivate(field.getModifiers())){
                privateFields.add(field);
            }
        }
        return privateFields;
    }
}
