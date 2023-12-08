import model.Round;

public class GameInspector {
    public boolean isRoundValid(Round exampleBag, Round control)
    {

        return exampleBag.getBlue() == 0 &&
                exampleBag.getRed() <= control.getRed() &&
                exampleBag.getGreen() == 0;
    }

}
