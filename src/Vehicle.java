abstract class Vehicle {
    //interface

    private int intID;
    private String strName;
    private String strType;
    private Double dblFee;

    public Vehicle(int ID, String Name, String Type, Double Fee){
        this.intID = ID;
        this.strName = Name;
        this.strType = Type;
        this.dblFee = Fee;
    }

    public int getIntID() {
        return intID;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrType() {
        return strType;
    }

    public void setStrType(String strType) {
        this.strType = strType;
    }

    public Double getDblFee() {
        return dblFee;
    }

    public void setDblFee(Double dblFee) {
        this.dblFee = dblFee;
    }

    public String testRun(){
        return "Vehicle was Tested";
    }

    @Override
    public String toString() {
        return "ID:"+intID+" Name:"+strName+" Issue:"+strType+" Fee: £" + dblFee;

    }

}
