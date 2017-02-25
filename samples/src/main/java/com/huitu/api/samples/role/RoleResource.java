package com.huitu.api.samples.role;

import com.huitu.api.rest.*;
import com.huitu.api.samples.exception.SampleErrorCode;
import com.huitu.api.samples.role.service.RoleService;
import com.huitu.api.samples.user.UserByRoleResource;
import com.huitu.exception.ErrorCodeFactory;
import org.glassfish.jersey.server.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
@Path("roles")
public class RoleResource  extends AbstractApiResource {
    private static final Logger logger = LoggerFactory.getLogger(RoleResource.class);
    private static String uuid = "892cf0f6-d625-41f1-977e-0ae132ab1165";

    @Override
    public String getUUID() {
        return uuid;
    }

    private RoleService roleService;
    public RoleService getRoleService() {
        return roleService;
    }
    public void setRoleService(RoleService value) {
        this.roleService = value;
    }

    /**
     * @api {get} roles 获取所有角色信息
     * @apiDescription 获取所有角色信息
     * @apiName get all roles
     * @apiGroup 角色信息
     * @apiVersion 0.1.0
     *
     * @apiSampleRequest  roles
     *
     *
     * @apiSuccess {string} [key] 角色标识
     * @apiSuccess {string} ID  角色标识
     * @apiSuccess {string} NAME 角色名称
     *
     * @apiSuccessExample 请求成功:
     *     HTTP/1.1 200 OK
     *     {
     *      "result":{
     *          "60623F69-6361-4386-BD8E-1F9ED9A6BC21":{
     *              "ID":"60623F69-6361-4386-BD8E-1F9ED9A6BC21",
     *              "USERNAME":"系统管理员"
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
    public Response getRoles() {
        ApiResult sr = null;
        Response response = null;
        try {

            Map<String,Object> result = roleService.getRoles();

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
     * @api {get} roles/{id} 根据角色ID查询指定角色信息
     * @apiDescription 根据角色ID查询指定角色信息
     * @apiName get one role by id
     * @apiGroup 角色信息
     * @apiVersion 0.1.0
     *
     * @apiParam {string} roidId  role id
     *
     * @apiSampleRequest  roles
     *
     *
     * @apiSuccess {string} ID  角色标识
     * @apiSuccess {string} NAME 角色名称
     *
     * @apiSuccessExample 请求成功:
     *     HTTP/1.1 200 OK
     *     {
     *      "result":{
     *          "ID":"60623F69-6361-4386-BD8E-1F9ED9A6BC21",
     *          "USERNAME":"系统管理员"
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
    @Path(value ="{roleId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getById(@PathParam(value ="roleId") String roleId ) {
        ApiResult sr = null;
        Response response = null;
        try {

            Map<String,Object> result = roleService.getById(roleId);

            sr = new SuccessResult<>(this,result);

            response = Response.ok(sr).status(Response.Status.OK).build();
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            sr = new FailureResult(this, ErrorCodeFactory.Create(SampleErrorCode.SELECT_PARAM,ex.getMessage()),ex);
            response = Response.ok(sr).status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }



    /*
    * 子资源
    * */
    @Path("{roleId}/users")
    public Resource getStByAdcdAndSttp(@PathParam("roleId")String roleId){
        return Resource.from(UserByRoleResource.class);
    }
}
