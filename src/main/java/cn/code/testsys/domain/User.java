package cn.code.testsys.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements java.io.Serializable{//接口可去掉，但是会报不影响运行但是看着不舒服的错
    private Long id;
    private String number;
    private String name;
    private String password;
    private int dep;
    private int who;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", dep=" + dep +
                ", who=" + who +
                '}';
    }
}
