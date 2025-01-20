package tool;

public interface Acceptable {

    public final String STUDENT_ID = "^[CcDdHhSsQq][Ee]\\d{6}$";
    public final String NAME_VALID = "^.{2,20}$";
    public final String DOUBLE_VALID = "[+-]?\\\\d+.?(\\\\d+)?";
    public final String INTEGER_VALID = "\\d+";
    public final String PHONE_VALID = "0\\d{9}$";
    public final String VNPT_VALID = "^(081|082|083|084|085|088|091|094)\\d{7}$";
    public final String VIETTEL_VALID = "^(086|096|097|098|039|038|037|036|035|034|033|032)\\d{7}$";
    public final String EMAIL_VALID = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
}