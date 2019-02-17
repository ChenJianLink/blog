package cn.chenjianlink.blog.shiro;

import cn.chenjianlink.blog.pojo.Blogger;
import cn.chenjianlink.blog.service.BloggerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * 自定义realm
 */
public class BlogRealm extends AuthorizingRealm {

    @Resource
    private BloggerService bloggerService;

    @Override
    public String getName() {
        return super.getName();
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Blogger blogger = bloggerService.findPassword();
        if (!blogger.getUserName().equals(username)) {
            throw new UnknownAccountException();//没找到帐号
        }
        SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(blogger.getUserName(), blogger.getPassword(), ByteSource.Util.bytes(blogger.getSalt()), getName());
        return authenticationInfo;
    }

}
