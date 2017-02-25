define({ "api": [
  {
    "type": "put",
    "url": "users",
    "title": "新建用户",
    "description": "<p>新建用户</p>",
    "name": "create_user",
    "group": "用户信息",
    "version": "0.1.0",
    "sampleRequest": [
      {
        "url": "users"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "ok",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求成功:",
          "content": "HTTP/1.1 200 OK\n{\n \"result\":\"ok\"\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NotFound",
            "description": "<p>请求未发现</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求异常:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"NotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "samples/user/UserCURDResource.java",
    "groupTitle": "用户信息",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "string",
            "optional": true,
            "field": "id",
            "description": "<p>用户标识</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "name",
            "description": "<p>用户名称</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Parameter",
            "type": "number",
            "optional": false,
            "field": "age",
            "description": "<p>年龄</p>"
          },
          {
            "group": "Parameter",
            "type": "number",
            "optional": false,
            "field": "sex",
            "description": "<p>性别：1 男,2 女,3 未设置</p>"
          },
          {
            "group": "Parameter",
            "type": "bool",
            "optional": true,
            "field": "locked",
            "description": "<p>true 户已锁定,false 用户未锁定</p>"
          }
        ]
      }
    }
  },
  {
    "type": "delete",
    "url": "users/{id}",
    "title": "删除用户",
    "description": "<p>删除用户</p>",
    "name": "delete_one_user_by_user_id",
    "group": "用户信息",
    "version": "0.1.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "id",
            "description": "<p>用户标识</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "users/{id}"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "ok",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求成功:",
          "content": "HTTP/1.1 200 OK\n{\n \"result\":\"ok\"\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NotFound",
            "description": "<p>请求未发现</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求异常:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"NotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "samples/user/UserCURDResource.java",
    "groupTitle": "用户信息"
  },
  {
    "type": "get",
    "url": "{?roleId}/users",
    "title": "[根据 角色标识]获取所有用户信息",
    "description": "<p>[根据 角色标识]获取所有用户信息</p>",
    "name": "get_all_users__by_role_id_",
    "group": "用户信息",
    "version": "0.1.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "string",
            "optional": true,
            "field": "roidId",
            "description": "<p>role id</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "{?roleId}/users"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "key",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "ID",
            "description": "<p>用户ID</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "USERNAME",
            "description": "<p>用户名称</p>"
          },
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "LOCKED",
            "description": "<p>是否锁定 1表示锁定，不能进行登录</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求成功:",
          "content": "HTTP/1.1 200 OK\n{\n \"result\":{\n     \"05A8ED3E-0BC2-455C-8EB9-6BEC733BBCD1\":{\n         \"ID\":\"05A8ED3E-0BC2-455C-8EB9-6BEC733BBCD1\",\n         \"USERNAME\":\"fxuser\",\n         \"LOCKED\":0\n     }\n }\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NotFound",
            "description": "<p>请求未发现</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求异常:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"NotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "samples/user/UserByRoleResource.java",
    "groupTitle": "用户信息"
  },
  {
    "type": "get",
    "url": "users/{id}",
    "title": "根据用户标识获取用户信息",
    "description": "<p>根据用户标识获取用户信息</p>",
    "name": "get_one_user_by_user_id",
    "group": "用户信息",
    "version": "0.1.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "id",
            "description": "<p>user id</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "users/{id}"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "ID",
            "description": "<p>用户标识</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "USERNAME",
            "description": "<p>用户名称</p>"
          },
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "LOCKED",
            "description": "<p>是否锁定 1表示锁定，不能进行登录</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求成功:",
          "content": "HTTP/1.1 200 OK\n{\n \"result\":{\n     \"ID\":\"05A8ED3E-0BC2-455C-8EB9-6BEC733BBCD1\",\n    \"USERNAME\":\"fxuser\",\n    \"LOCKED\":0\n }\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NotFound",
            "description": "<p>请求未发现</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求异常:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"NotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "samples/user/UserResource.java",
    "groupTitle": "用户信息"
  },
  {
    "type": "post",
    "url": "users",
    "title": "根据用户标识数组获取用户信息",
    "description": "<p>根据用户标识数组获取用户信息</p>",
    "name": "get_same_users_by_user_id_array",
    "group": "用户信息",
    "version": "0.1.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "string[]",
            "optional": false,
            "field": "id",
            "description": "<p>user id</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "users"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "ID",
            "description": "<p>用户标识</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "USERNAME",
            "description": "<p>用户名称</p>"
          },
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "LOCKED",
            "description": "<p>是否锁定 1表示锁定，不能进行登录</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求成功:",
          "content": "HTTP/1.1 200 OK\n{\n \"result\":{\n     \"05A8ED3E-0BC2-455C-8EB9-6BEC733BBCD1\":{\n         \"ID\":\"05A8ED3E-0BC2-455C-8EB9-6BEC733BBCD1\",\n         \"USERNAME\":\"fxuser\",\n         \"LOCKED\":0\n     }\n }\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NotFound",
            "description": "<p>请求未发现</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求异常:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"NotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "samples/user/UserResource.java",
    "groupTitle": "用户信息"
  },
  {
    "type": "put",
    "url": "users/{id}/update",
    "title": "更新用户",
    "description": "<p>更新用户</p>",
    "name": "update_one_user_by_user_id",
    "group": "用户信息",
    "version": "0.1.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "id",
            "description": "<p>用户标识</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "name",
            "description": "<p>用户名称</p>"
          },
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Parameter",
            "type": "number",
            "optional": false,
            "field": "age",
            "description": "<p>年龄</p>"
          },
          {
            "group": "Parameter",
            "type": "number",
            "optional": false,
            "field": "sex",
            "description": "<p>性别：1 男,2 女,3 未设置</p>"
          },
          {
            "group": "Parameter",
            "type": "bool",
            "optional": true,
            "field": "locked",
            "description": "<p>true 户已锁定,false 用户未锁定</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "users/{id}/update"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "ok",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求成功:",
          "content": "HTTP/1.1 200 OK\n{\n \"result\":\"ok\"\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NotFound",
            "description": "<p>请求未发现</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求异常:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"NotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "samples/user/UserCURDResource.java",
    "groupTitle": "用户信息"
  },
  {
    "type": "get",
    "url": "roles",
    "title": "获取所有角色信息",
    "description": "<p>获取所有角色信息</p>",
    "name": "get_all_roles",
    "group": "角色信息",
    "version": "0.1.0",
    "sampleRequest": [
      {
        "url": "roles"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "string",
            "optional": true,
            "field": "key",
            "description": "<p>角色标识</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "ID",
            "description": "<p>角色标识</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "NAME",
            "description": "<p>角色名称</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求成功:",
          "content": "HTTP/1.1 200 OK\n{\n \"result\":{\n     \"60623F69-6361-4386-BD8E-1F9ED9A6BC21\":{\n         \"ID\":\"60623F69-6361-4386-BD8E-1F9ED9A6BC21\",\n         \"USERNAME\":\"系统管理员\"\n     }\n }\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NotFound",
            "description": "<p>请求未发现</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求异常:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"NotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "samples/role/RoleResource.java",
    "groupTitle": "角色信息"
  },
  {
    "type": "get",
    "url": "roles/{id}",
    "title": "根据角色ID查询指定角色信息",
    "description": "<p>根据角色ID查询指定角色信息</p>",
    "name": "get_one_role_by_id",
    "group": "角色信息",
    "version": "0.1.0",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "string",
            "optional": false,
            "field": "roidId",
            "description": "<p>role id</p>"
          }
        ]
      }
    },
    "sampleRequest": [
      {
        "url": "roles"
      }
    ],
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "ID",
            "description": "<p>角色标识</p>"
          },
          {
            "group": "Success 200",
            "type": "string",
            "optional": false,
            "field": "NAME",
            "description": "<p>角色名称</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求成功:",
          "content": "HTTP/1.1 200 OK\n{\n \"result\":{\n     \"ID\":\"60623F69-6361-4386-BD8E-1F9ED9A6BC21\",\n     \"USERNAME\":\"系统管理员\"\n }\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "optional": false,
            "field": "NotFound",
            "description": "<p>请求未发现</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求异常:",
          "content": "HTTP/1.1 404 Not Found\n{\n  \"error\": \"NotFound\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "samples/role/RoleResource.java",
    "groupTitle": "角色信息"
  }
] });
