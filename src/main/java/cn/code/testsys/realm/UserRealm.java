package cn.code.testsys.realm;

import cn.code.testsys.domain.User;
import cn.code.testsys.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService iUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        User user=iUserService.getByNameAndPass(token.getUsername(), String.valueOf(token.getPassword()));

        if(user==null){
            return null;
        }
        else{
            return new SimpleAuthenticationInfo(
                    user,
                    user.getPassword(),
                    user.getName()
            );
        }
    }
}
