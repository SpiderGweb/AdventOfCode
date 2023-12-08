import model.Round;

public class GameInspector {
    public boolean isRoundValid(Round exampleBag, Round control)
    {
        return exampleBag.getBlue() <= control.getBlue() &&
                exampleBag.getRed() <= control.getRed() &&
                exampleBag.getGreen() <= control.getGreen();
    }

}
