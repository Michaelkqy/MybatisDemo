package com.huitu.api.samples.user;

import com.huitu.api.rest.AbstractApiResource;
import com.huitu.api.rest.ApiResult;
import com.huitu.api.rest.FailureResult;
import com.huitu.api.rest.SuccessResult;
import com.huitu.api.samples.exception.SampleErrorCode;
import com.huitu.api.samples.user.service.UserService;
import com.huitu.exception.ErrorCodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by zhw on 2016/12/16.
 */
@Component
@Path("users")
public class UserByRoleResource extends AbstractApiResource {
    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static String uuid = "b7eff66e-729a-47a2-86c7-69a211168e09";

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService value) {
        this.userService = value;
    }

    @Override
    public String getUUID() {
        return uuid;
    }


    @PathParam("roleId")
    private String roleId;
    /**
     * @api {get} {?roleId}/users [根据 角色标识]获取所有用户信息
     * @apiDescription  [根据 角色标识]获取所有用户信息
     * @apiName get all users [by role id]
     * @apiGroup 用户信息
     * @apiVersion 0.1.0
     *
     * @apiParam {string} [roidId] role id
     *
     * @apiSampleRequest  {?roleId}/users
     *
     *
     * @apiSuccess {String} [key] 用户ID
     * @apiSuccess {String} ID  用户ID
     * @apiSuccess {String} USERNAME 用户名称
     * @apiSuccess {int} LOCKED 是否锁定 1表示锁定，不能进行登录
     *
     * @apiSuccessExample 请求成功:
     *     HTTP/1.1 200 OK
     *     {
     *      "result":{
     *          "05A8ED3E-0BC2-455C-8EB9-6BEC733BBCD1":{
     *              "ID":"05A8ED3E-0BC2-455C-8EB9-6BEC733BBCD1",
     *              "USERNAME":"fxuser",
     *              "LOCKED":0
     *          }
     *      }
     *      }
     *
     *  @apiError NotFound 请求未发现
     *
     * @apiErrorExample 请求异常:
     *     HTTP/1.1 404 Not Found
     *     {
     *       "error": "NotFound"
     *     }
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response geAll() {
        ApiResult sr = null;
        Response response = null;
        try {

            Map<String,Object> result = null;

            if(StringUtils.hasLength(roleId)){
                result =  userService.getByRoleId(roleId) ;
            } else {
                result =  userService.getAll();
            }

            sr = new SuccessResult<>(this,result);

            response = Response.ok(sr).status(Response.Status.OK).build();
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            sr = new FailureResult(this, ErrorCodeFactory.Create(SampleErrorCode.SELECT_PARAM,ex.getMessage()),ex);
            response = Response.ok(sr).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

}

