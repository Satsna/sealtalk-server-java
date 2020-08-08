package com.rcloud.server.sealtalk.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Jianlu.Yu
 * @Date: 2020/8/5
 * @Description:
 * @Copyright (c) 2020, rongcloud.cn All Rights Reserved
 */
public class CacheUtil {

    public static final String NICK_NAME_CACHE_PREFIX = "nickname_";
    public static final String USER_CACHE_PREFIX = "user_";
    public static final String FRIENDSHIP_PROFILE_CACHE_PREFIX = "friendship_profile_user_";
    public static final String FRIENDSHIP_ALL_CACHE_PREFIX = "friendship_all_";
    public static final String GROUP_MEMBERS_CACHE_PREFIX = "group_members_";
    public static final String USER_BLACKLIST_CACHE_PREFIX = "user_blacklist_";

    public static final String FRIENDSHIP_PROFILE_DISPLAYNAME_CACHE_PREFIX = "friendship_profile_displayName_";

    public static final String USER_GROUP_CACHE_PREFIX = "user_groups_";






    private static Cache<String,String> cache = CacheBuilder.newBuilder()
            .maximumSize(100000)
            .expireAfterWrite(3600000, TimeUnit.MILLISECONDS)
            .build();

    public static String get(String key){
        return cache.getIfPresent(key);
    }

    public static void set(String key,String value){
        cache.put(key,value);
    }

    public static void delete(String key){
        cache.invalidate(key);
    }



}


