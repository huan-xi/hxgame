package com.huanxi;


import com.huanxi.birdgame.BirdGame;

/**
 * 笨鸟先飞游戏
 *
 *
 * 游戏引擎设计思路
 * 游戏时间： 睡眠时间乘次数
 * 对象说明：
 *      游戏物体：渲染方法，控制方法
 *      渲染：调用paint方法
 *      渲染链（RenderFilter）职责：对实现某接口的物体做对应的渲染规则
 *      渲染执行者职责(GameRender)：统一调用渲染链的render方法（render表）
 *      游戏全局变量(hxgame): 状态控制
 *      游戏画板：
 * 游戏初始化： 创建所有游戏物体并加入加入渲染链
 *
 *
 * 重力控制染链
 * 碰撞检测控制链
 * 控制链
 */
public class Main {
     public static void main(String [] args){
         BirdGame.start();
      }
}
