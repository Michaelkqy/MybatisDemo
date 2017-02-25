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


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;


/**
 * Created by zhw on 2016/12/16.
 * <p>用户管理访问资源类<br>
 *
 * @author zhw <br>
 * @version v0.1 <br>
 */
@Component
@Path("users")
public class UserResource extends AbstractApiResource {
    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static String uuid = "fb43b03d-ccf4-444a-8a19-23dd0d6d4657";

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

    /**
     * @api {get} users/{id} 根据用户标识获取用户信息
     * @apiDescription 根据用户标识获取用户信息
     * @apiName get one user by user id
     * @apiGroup 用户信息
     * @apiVersion 0.1.0
     *
     * @apiParam {string} id user id
     *
     * @apiSampleRequest  users/{id}
     *
     *
     * @apiSuccess {string} ID  用户标识
     * @apiSuccess {string} USERNAME 用户名称
     * @apiSuccess {int} LOCKED 是否锁定 1表示锁定，不能进行登录
     *
     * @apiSuccessExample 请求成功:
     *     HTTP/1.1 200 OK
     *     {
     *      "result":{
     *          "ID":"05A8ED3E-0BC2-455C-8EB9-6BEC733BBCD1",
     *         "USERNAME":"fxuser",
     *         "LOCKED":0
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
    @Path(value ="{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getById(@PathParam(value ="id") String id ) {
        ApiResult sr = null;
        Response response = null;
        try {

            Map<String,Object> result = userService.getById(id);

            sr = new SuccessResult<>(this,result);

            response = Response.ok(sr).status(Response.Status.OK).build();
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            sr = new FailureResult(this, ErrorCodeFactory.Create(SampleErrorCode.SELECT_PARAM,ex.getMessage()),ex);
            response = Response.ok(sr).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }


    /**
     * @api {post} users 根据用户标识数组获取用户信息
     * @apiDescription 根据用户标识数组获取用户信息
     * @apiName get same users by user id array
     * @apiGroup 用户信息
     * @apiVersion 0.1.0
     *
     * @apiParam {string[]} id user id
     *
     * @apiSampleRequest  users
     *
     *
     * @apiSuccess {string} ID  用户标识
     * @apiSuccess {string} USERNAME 用户名称
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
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getByIds(String [] ids) {
        ApiResult sr = null;
        Response response = null;
        try {

            Map<String,Object> result =  userService.getByIds(ids);

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
