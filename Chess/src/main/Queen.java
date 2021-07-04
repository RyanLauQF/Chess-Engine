import java.util.ArrayList;

public class Queen extends Piece{

    /*
     * Move Rules:
     * 1) Queen can move/attack in all directions (diagonally, horizontally and vertically)
     *
     * Queen moves by sliding. Check if piece is blocked by any piece. If piece is enemy, attack is possible.
     * Similar implementation to a Bishop + Rook movement
     */

    private static final int QUEEN_VALUE = 9;

    public Queen(boolean isWhite, int position, Board b){
        super(isWhite, position, b);
        this.type = PieceType.QUEEN;
    }

    @Override
    public ArrayList<Short> getDefendingSquares(){
        ArrayList<Short> list = new ArrayList<>();
        int end, offSet;
        int[] directions = MoveDirections.getDirections(getPosition());
        for(int index = 0; index < 8; index++){
            offSet = MoveDirections.directionOffSets[index];
            for(int i = 0; i < directions[index]; i++){
                end = getPosition() + (offSet * (i + 1));
                list.add(MoveGenerator.generateMove(getPosition(), end, 0));
                if(super.board.getTile(end).isOccupied()){
                    break;  // if piece is blocked, break from loop
                }
            }
        }
        return list;
    }

    @Override
    public int getValue(){
        return QUEEN_VALUE;
    }

    @Override
    public String toString(){
        return "Q";
    }
}
