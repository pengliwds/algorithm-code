package com.pengli.designPattern.structural.flyweightPattern;

/**
 * 享元模式是一种结构型设计模式，它通过共享对象来减少内存使用，特别适用于需要创建大量相似对象的场景。
 * <p>
 * 共享对象：将对象的内部状态（不变的部分）与外部状态（变化的部分）分离
 * 内部状态：存储在享元对象内部，可以被多个对象共享
 * 外部状态：由客户端存储，使用时传递给享元对象
 * <p>
 * 需要创建大量相似对象
 * 对象的大部分状态可以外部化
 * 内存占用是需要关注的问题
 * 对象身份不是特别重要
 */
public class FlyweightPatternTest {

    public static void main() {

        System.out.println("=== 围棋棋盘示例 ===");

        // 创建棋盘
        Position[][] board = new Position[19][19];

        // 初始化棋盘位置
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = new Position(i, j);
            }
        }

        // 摆放棋子（模拟对局）
        ChessPiece blackPiece = ChessPieceFactory.getChessPiece("黑色");
        ChessPiece whitePiece = ChessPieceFactory.getChessPiece("白色");

        // 摆放黑子
        blackPiece.display(board[3][3]);
        blackPiece.display(board[4][4]);
        blackPiece.display(board[5][5]);

        // 摆放白子
        whitePiece.display(board[3][4]);
        whitePiece.display(board[4][3]);

        System.out.println("\n棋盘上摆放了 5 个棋子，但只创建了 " +
                ChessPieceFactory.getPieceCount() + " 个棋子对象");

    }


}
