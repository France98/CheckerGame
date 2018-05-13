package project;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class CheckerApp{

	public static final int TILESIZE = 100;
	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	boolean turn = false;

	private Tile[][] board = new Tile[WIDTH][HEIGHT];

	private Group tileGroup = new Group();
	private Group pieceGroup = new Group();

	public Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(WIDTH * TILESIZE, HEIGHT * TILESIZE);
		root.getChildren().addAll(tileGroup, pieceGroup);

		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				Tile tile = new Tile((x + y) % 2 == 0, x, y);
				board[x][y] = tile;

				tileGroup.getChildren().add(tile);

				Piece piece = null;

				if (y <= 2 && (x + y) % 2 != 0) {
					piece = makePiece(PieceType.BLACK, x, y);
				}

				if (y >= 5 && (x + y) % 2 != 0) {
					piece = makePiece(PieceType.WHITE, x, y);
				}

				if (piece != null) {
					tile.setPiece(piece);
					pieceGroup.getChildren().add(piece);
				}
			}
		}

		return root;
	}

	private MoveResult tryMove(Piece piece, int newX, int newY) {

		if (board[newX][newY].hasPiece() || (newX + newY) % 2 == 0) {
			return new MoveResult(MoveType.NONE);
		}
		int x0 = toBoard(piece.getOldX());
		int y0 = toBoard(piece.getOldY());

		if (Math.abs(newX - x0) == 1 && newY - y0 == piece.getType().moveD) {
			return new MoveResult(MoveType.NORMAL);
		} else if (Math.abs(newX - x0) == 2 && ((newY - y0 == piece.getType().moveD * 2 && !piece.isKing()) || (Math.abs(newY - y0) == 2 && piece.isKing() ))) {

            int x1 = x0 + (newX - x0) / 2;
            int y1 = y0 + (newY - y0) / 2;

            if (board[x1][y1].hasPiece() && board[x1][y1].getPiece().getType() != piece.getType()) {
                return new MoveResult(MoveType.KILL, board[x1][y1].getPiece());
            }
        }
		 else if ((Math.abs(newX - x0) == 1 && (Math.abs(newY - y0) == 1)  && piece.isKing())) {
			return new MoveResult(MoveType.NORMAL);
		}

		return new MoveResult(MoveType.NONE);
	}

	private int toBoard(double pixel) {
		return (int) (pixel + TILESIZE / 2) / TILESIZE;
	}

	private Piece makePiece(PieceType type, int x, int y) {
		Piece piece = new Piece(type, x, y);
		piece.setOnMouseReleased(e -> {
			for (int i = 0; i < 7; i++) {
				if (board[i][0].hasPiece()) {
					if (board[i][0].getPiece().getType() == type.WHITE) {
						board[i][0].getPiece().setKing();
					}
				}
			}
			for (int i = 0; i < 7; i++) {
				if (board[i][7].hasPiece()) {
					if (board[i][7].getPiece().getType() == type.BLACK) {
						board[i][7].getPiece().setKing();
					}
				}
			}
			int newX = toBoard(piece.getLayoutX());
			int newY = toBoard(piece.getLayoutY());
			if ((turn == false && (piece.getType() == type.WHITE))
					|| (turn == true && (piece.getType() == type.BLACK))) {

				MoveResult result;

				if (newX < 0 || newY < 0 || newX >= WIDTH || newY >= HEIGHT) {
					result = new MoveResult(MoveType.NONE);
				} else {
					result = tryMove(piece, newX, newY);
				}

				int x0 = toBoard(piece.getOldX());
				int y0 = toBoard(piece.getOldY());

				switch (result.getType()) {
				case NONE:
					piece.abortMove();
					break;
				case NORMAL:
					piece.move(newX, newY);
					board[x0][y0].setPiece(null);
					board[newX][newY].setPiece(piece);
					break;
				case KILL:
					piece.move(newX, newY);
					board[x0][y0].setPiece(null);
					board[newX][newY].setPiece(piece);

					Piece otherPiece = result.getPiece();
					board[toBoard(otherPiece.getOldX())][toBoard(otherPiece.getOldY())].setPiece(null);
					pieceGroup.getChildren().remove(otherPiece);
					break;
				default:
					break;
				}
				
				for (int i = 0; i < 7; i++) {
					if (board[i][0].hasPiece()) {
						if (board[i][0].getPiece().getType() == type.WHITE) {
							board[i][0].getPiece().setKing();
						}
					}
				}
				for (int i = 0; i < 7; i++) {
					if (board[i][7].hasPiece()) {
						if (board[i][7].getPiece().getType() == type.BLACK) {
							board[i][7].getPiece().setKing();
						}
					}
				}
				if (result.getType() != MoveType.NONE) {
					turn = !turn;
				}
			} else {
				piece.abortMove();
			}
		});
		return piece;
	}

}
