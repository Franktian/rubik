package com.onecube;

public class Boundary {
	private Point[] points; // Points making up the boundary
	
	public Boundary (Point upLeft, Point upRight, Point bottomLeft, Point bottomRight) {
		this.points = new Point[] {upLeft, upRight, bottomLeft, bottomRight};
	}
	
	/**
     * Return true if the given point is contained inside the boundary.
     * See: http://www.ecse.rpi.edu/Homepages/wrf/Research/Short_Notes/pnpoly.html
     * @param test The point to check
     * @return true if the point is inside the boundary, false otherwise
     *
     */
    public boolean contains(Point test) {
    	int i, j;
    	boolean result = false;
    	for (i = 0, j = points.length - 1; i < points.length; j = i++) {
    		if ((points[i].y > test.y) != (points[j].y > test.y) &&
    		(test.x < (points[j].x - points[i].x) * (test.y - points[i].y) / (points[j].y-points[i].y) + points[i].x)) {
    			result = !result;
    		}
    	}
    	return result;
    }
}
