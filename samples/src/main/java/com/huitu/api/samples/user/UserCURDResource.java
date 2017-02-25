package com.huitu.api.samples.user;

import com.huitu.api.rest.AbstractApiResource;
import com.huitu.api.rest.ApiResult;
import com.huitu.api.rest.FailureResult;
import com.huitu.api.rest.SuccessResult;
import com.huitu.api.samples.exception.SampleErrorCode;
import com.huitu.api.samples.user.entities.UserEntity;
import com.huitu.exception.ErrorCodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by zhw on 2017/2/22.
 */
@Component
@Path("users")
public class UserCURDResource extends AbstractApiResource  {

    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static String uuid = "46eedbe4-e4ec-4dbb-b3af-241c91b20979";


    @Override
    public String getUUID() {
        return uuid;
    }


    /**
    * @apiDefine UserEneity
    * @apiParam {string} [id] 用户标识
    * @apiParam {string} name 用户名称
    * @apiParam {string} nickname 昵称
    * @apiParam {number} age 年龄
    * @apiParam {number} sex 性别：1 男,2 女,3 未设置
    * @apiParam {bool} [locked] true 户已锁定,false 用户未锁定
    */

    /**
     * @api {put} users 新建用户
     * @apiDescription 新建用户
     * @apiName create user
     * @apiGroup 用户信息
     * @apiVersion 0.1.0
     *
     * @apiUse UserEneity
     *
     * @apiSampleRequest  users
     *
     *
     * @apiSuccess {string} ok
     *
     * @apiSuccessExample 请求成功:
     *     HTTP/1.1 200 OK
     *     {
     *      "result":"ok"
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
    @PUT
//    @Path(value ="/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response Create(UserEntity user ) {
        ApiResult sr = null;
        Response response = null;
        try {

            //service insert one user record
            /*
            *
            *  insert logic
            *
            * */

            sr = new SuccessResult(this, "OK");
            response = Response.ok(sr).status(Response.Status.OK).build();
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            sr = new FailureResult(this, ErrorCodeFactory.Create(SampleErrorCode.CRATE_USER,ex.getMessage()),ex);
            response = Response.ok(sr).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }


    /**
     * @api {put} users/{id}/update 更新用户
     * @apiDescription 更新用户
     * @apiName update one user by user id
     * @apiGroup 用户信息
     * @apiVersion 0.1.0
     *
     * @apiUse UserEneity
     * @apiParam {string} id 用户标识
     *
     * @apiSampleRequest  users/{id}/update
     *
     *
     * @apiSuccess {string} ok
     *
     * @apiSuccessExample 请求成功:
     *     HTTP/1.1 200 OK
     *     {
     *      "result":"ok"
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
    @PUT
    @Path(value ="/{id}/update")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response Update(@PathParam(value ="id") String id,UserEntity user ) {
        ApiResult sr = null;
        Response response = null;
        try {

            //service insert one user record
            /*
            *
            *  update logic
            *
            * */

            sr = new SuccessResult(this, "OK");
            response = Response.ok(sr).status(Response.Status.OK).build();
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            sr = new FailureResult(this, ErrorCodeFactory.Create(SampleErrorCode.CRATE_USER,ex.getMessage()),ex);
            response = Response.ok(sr).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }



    /**
     * @api {delete} users/{id} 删除用户
     * @apiDescription 删除用户
     * @apiName delete one user by user id
     * @apiGroup 用户信息
     * @apiVersion 0.1.0
     *
     * @apiParam {string} id 用户标识
     *
     * @apiSampleRequest  users/{id}
     *
     *
     * @apiSuccess {string} ok
     *
     * @apiSuccessExample 请求成功:
     *     HTTP/1.1 200 OK
     *     {
     *      "result":"ok"
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
    @DELETE
    @Path(value ="/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response Delete(@PathParam(value ="id") String id) {
        ApiResult sr = null;
        Response response = null;
        try {

            //service insert one user record
            /*
            *
            *  delete logic
            *
            * */

            sr = new SuccessResult(this, "OK");
            response = Response.ok(sr).status(Response.Status.OK).build();
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            sr = new FailureResult(this, ErrorCodeFactory.Create(SampleErrorCode.CRATE_USER,ex.getMessage()),ex);
            response = Response.ok(sr).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }
}
