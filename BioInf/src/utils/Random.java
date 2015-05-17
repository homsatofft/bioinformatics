package utils;

public class Random {
	double[] _distribution;
	private double _sum;
	private java.util.Random _random;

	public Random(double[] distribution) {
		setDistribution(distribution);
		_random = new java.util.Random();
	}

	public void setDistribution(double[] distribution) {
		_sum = 0.0;
		_distribution = distribution;
		String exception = new String();
		for (double d : _distribution) {
			if (d < 0) {
				exception += String.format(
						"Negative value %f found! in distribution!\n", d);
			}
			_sum += d;
		}
		if (_sum <= 0) {
			exception += String.format("Non-positive distribution sum: %f",
					_sum);
		}
		if (exception.length() > 0) {
			throw new IllegalArgumentException(exception);
		}
	}

	public int nextInt() {
		double num = _random.nextDouble();
		double s = 0.0;
		int i;
		for (i = 0; i < _distribution.length; i++) {
			s += _distribution[i] / _sum;
			if (s >= num) {
				return i + 1;
			}
		}
		return i + 1;
	}
}
