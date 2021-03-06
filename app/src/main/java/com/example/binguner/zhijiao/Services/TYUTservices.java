package com.example.binguner.zhijiao.Services;

import com.example.binguner.zhijiao.Entity.AnnouncementBean;
import com.example.binguner.zhijiao.Entity.ClassArrangeBean;
import com.example.binguner.zhijiao.Entity.ClassBean;
import com.example.binguner.zhijiao.Entity.GradesBean;
import com.example.binguner.zhijiao.Entity.LoginBean;
import com.example.binguner.zhijiao.Entity.WorkBean;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by binguner on 2017/8/20.
 */

public interface TYUTservices {

    //http://tyut.ngrok.cc/notice/list
    //获取学校公告
    @GET("http://tyut.free.ngrok.cc/notice/list/{page}")
    Observable<AnnouncementBean> GetAnnouncement(@Path("page") int page);

    //http://helpstudy.ngrok.cc/help/list1
    //获取学校岗位
    /*
    *  1 固定岗
    *  2 临时岗
    *  3 专业技术岗
    *  4 校外岗
    *
    * */
    @GET("http://helpstudy.free.ngrok.cc/help/list{type}/{page}")
    Observable<WorkBean> GetWorkInfo(@Path("type") int type,@Path("page") int page);


    //http://grade.ngrok.cc/login
    @FormUrlEncoded
    @POST("http://grade.free.ngrok.cc/login")
    Observable<LoginBean> FirsrLogin(@Field("username") String username,@Field("password") String password);

    //http://grade.ngrok.cc/grade
    @FormUrlEncoded
    @POST("http://grade.free.ngrok.cc/grade")
    Observable<GradesBean> GetGrades(@Field("username") String username,@Field("password") String password/*@Header("Set-Cookie") String cookie */   /*@Path("username"*/);/* String username*/

    //获取课表
    //http://grade.ngrok.cc/class
    @FormUrlEncoded
    @POST("http://grade.free.ngrok.cc/class")
    Observable<ClassBean> GetClass(@Field("username") String username,@Field("password") String password);

    //获取课表详情
    //http://grade.ngrok.cc/classArrange
    @FormUrlEncoded
    @POST("http://grade.free.ngrok.cc/classArrange")
    Observable<ClassArrangeBean>  GetClassArray(@Field("username") String username,@Field("password") String password);
}
