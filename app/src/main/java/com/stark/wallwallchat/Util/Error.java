package com.stark.wallwallchat.Util;

/**
 * Created by Stark on 2017/2/13.
 */
public class Error {
    public static String error(int i){
        switch (i){
            case -2:
                return "神奇的异常";
            case -1:
                return "网络异常，请检查网络";
            case 0:
                return "操作成功";
            case 1:
                return "密码错误！";
            case 2:
                return "验证码有误！";
            case 3:
                return "已在其他设备登录";
            case 5:
                return "服务器异常";
            case 6:
                return "数据异常";
            case 7:
                return "数据解析异常";
            case 8:
                return "文件在服务器已存在";
            case 9:
                return "文件已失效";
            case 10:
                return "文件上传失败";
            case 11:
                return "文件服务器异常";
            case 12:
                return "文件下载失败";
            case 13:
                return "信息获取失败";
            case 14:
                return "该手机号已经注册过账号";
            case 100:
                return "操作成功";
            case 101:
                return "请输入账号";
            case 102:
                return "密码不能为空";
            case 103:
                return "账号不存在";
            case 104:
                return "密码格式有误";
            case 105:
                return "昵称不能为空";
            case 106:
                return "请在确认栏中再次输入密码";
            case 107:
                return "密码不能少于六位";
            case 108:
                return "两次输入的密码不一致，请注意格式重新输入";
            case 109:
                return "请勿重复添加";
            case 110:
                return "文件操作错误";
            case 111:
                return "请选择学校";
            default:
                return "未知错误！";
        }
    }
}
