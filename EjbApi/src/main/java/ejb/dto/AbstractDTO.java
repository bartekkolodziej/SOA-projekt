package ejb.dto;

import java.io.Serializable;

public abstract class AbstractDTO implements Serializable{
    public abstract int getId();
    public abstract void setId(int id);
}
