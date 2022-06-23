package Course.CodeWars;


public class BattleField {

    private enum VectorEnum {
        horizontal, vertical;
    }

    private static class BattleShip {
        int x, y, length = 1;
        VectorEnum vector = null;

    }

    public static boolean fieldValidator(int[][] field) {
        BattleShip[] fleet1 = new BattleShip[4];
        BattleShip[] fleet2 = new BattleShip[3];
        BattleShip[] fleet3 = new BattleShip[2];
        BattleShip[] fleet4 = new BattleShip[1];

        BattleShip[][] fleets = new BattleShip[4][];

        System.out.print("\n");
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + ", ");
            }
            System.out.print("\n");
        }

        boolean result = true;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (!result) return false;

                int point = field[i][j];

                if (point == 1) {
                    Boolean onRight = false, onDown = false;

                    BattleShip ship = new BattleShip();
                    ship.y = i;
                    ship.x = j;

                    //++check contact
                    field[i][j] = 3;
                    result = checkContact(field, ship);
                    //--check contact

                    //++get vector
                    if (j + 1 < field.length) if (field[i][j + 1] == 1) onRight = true;
                    if (i + 1 < field.length) if (field[i + 1][j] == 1) onDown = true;

                    if (onRight && onDown) return false;
                    else if (onRight) ship.vector = VectorEnum.horizontal;
                    else ship.vector = VectorEnum.vertical;

                    int firstPoint = ship.vector == VectorEnum.vertical ? i : j;

                    for (int k = firstPoint + 1; k < firstPoint + 4; k++) {
                        if (ship.vector == VectorEnum.vertical) {
                            if (k >= field.length) break;
                        } else if (k >= field[0].length) break;

                        if (!result) return false;
                        int nowPoint = field[ship.vector == VectorEnum.vertical ? k : i][ship.vector == VectorEnum.vertical ? j : k];
                        if (nowPoint == 1) {
                            ship.length++;
                            result = checkContact(field, ship);
                            field[ship.vector == VectorEnum.vertical ? k : i][ship.vector == VectorEnum.vertical ? j : k] = 3;
                        } else
                            break;
                    }
                    //--get vector

                    try {
                        BattleShip[] fleet = null;

                        if (ship.length == 1) fleet = fleet1;
                        else if (ship.length == 2) fleet = fleet2;
                        else if (ship.length == 3) fleet = fleet3;
                        else if (ship.length == 4) fleet = fleet4;

                        boolean added = false;
                        for (int k = 0; k < fleet.length; k++) {
                            if (fleet[k] == null) {
                                fleet[k] = ship;
                                added = true;
                                break;
                            }
                        }
                        if (!added)
                            return false;

                    } catch (Exception e) {
                        return false;
                    }

                }


            }
            if (!result) return false;
        }

        fleets[0] = fleet1;
        fleets[1] = fleet2;
        fleets[2] = fleet3;
        fleets[3] = fleet4;

        for (int i = 0; i < fleets.length; i++) {
            for (int j = 0; j < fleets[i].length; j++) {
                if (fleets[i][j] == null) result = false;
            }
        }
        System.out.println(result);
        return result;
    }

    private static boolean checkContact(int[][] field, BattleShip ship) {
        boolean result = true;
        int i = ship.y + (ship.vector == VectorEnum.vertical ? ship.length - 1 : 0);
        int j = ship.x + (ship.vector == VectorEnum.vertical ? 0 : ship.length - 1);

        for (int k = i - 1; k < i + 2; k++) {
            if (k < 0 || k >= field.length) continue;
            for (int l = j - 1; l < j + 2; l++) {

                if (ship.vector != null || ship.length > 1) {
                    if (ship.vector == VectorEnum.vertical && k == i - 1 && l == j) continue;
                    if (ship.vector == VectorEnum.horizontal && k == i && l == j - 1) continue;
                }

                if (l < 0 || l >= field[k].length || (k == i && l == j)) continue;
                if (field[k][l] == 3) result = false;
            }
        }

        return result;
    }

}
