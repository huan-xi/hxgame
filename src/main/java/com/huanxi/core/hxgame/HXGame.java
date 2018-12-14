package com.huanxi.core.hxgame;

import com.huanxi.core.filter.controllerfilter.GameController;
import com.huanxi.core.filter.controllerfilter.boxfilter.gravitybox.GravityBox;
import com.huanxi.core.filter.renderfilter.GameRender;
import com.huanxi.core.util.Constant;

/**
 * HX全局游戏引擎(单例)
 */
public class HXGame {
    private int MAIN_FORM_WIDTH = 0;
    public static int game_status = Constant.GAME_STATUS_READY;
    private static HXGame hxGame;
    public static final int sleep_time = 10; //睡眠时间
    public static int times = 0; //游戏开始运行次数
    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private GameRender gameRender;
    private GameController gameController;
    private String title;

    private HXGame() {
        //初始化游戏窗体
        gameFrame = new GameFrame();
    }

    public void init() {
        // TODO Auto-generated method stub
        gameFrame.init();
        game_status = Constant.GAME_STATUS_RUN;
        //初始化渲染表
        gameRender = new GameRender();

        //初始化控制器
        gameController = new GameController();

        //初始化游戏画板
        gamePanel = GamePanel.createGamePanel(gameRender, gameController);
        gameFrame.setPanel(gamePanel);
    }

    public void start() {
        //启动渲染线程
        gameFrame.setVisible(true);
        gamePanel.start();
    }

    //添加游戏物体
    public void addGameObject(GameObject gameObject) {
        gameController.addGameObject(gameObject);
        gameRender.addGameObject(gameObject);

    }

    public int getGame_status() {
        return game_status;
    }

    public void setGame_status(int game_status) {
        this.game_status = game_status;
    }

    public static HXGame getHxGame() {
        if (hxGame == null)
            hxGame = new HXGame();
        return hxGame;
    }


    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public GameRender getGameRender() {
        return gameRender;
    }

    public void setGameRender(GameRender gameRender) {
        this.gameRender = gameRender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
