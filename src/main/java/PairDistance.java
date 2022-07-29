public class PairDistance {
    private int distanceWithoutTrafic;
    private int distanceWithTrafic;

    public PairDistance(int distanceWithoutTrafic, int distanceWithTrafic) {
        this.distanceWithoutTrafic = distanceWithoutTrafic;
        this.distanceWithTrafic = distanceWithTrafic;
    }

    public int getDistanceWithoutTrafic() {
        return distanceWithoutTrafic;
    }

    public int getDistanceWithTrafic() {
        return distanceWithTrafic;
    }
}
