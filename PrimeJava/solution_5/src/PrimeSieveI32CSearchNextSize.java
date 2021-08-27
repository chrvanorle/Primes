public class PrimeSieveI32CSearchNextSize extends PrimeSieveBaseBit{
	private static final int SHIFT_SIZE = 5;
	private static final int SHIFT_SIZE_ADD = SHIFT_SIZE + 1;// one more because we don't store even numbers
	private static final int SIZE = 1 << SHIFT_SIZE;
	private static final int MOD = (SIZE << 1) - 1;
	
	// bitset of odd numbers, zero means its a prime
	private final int[] dataSet;
	
	private static final int[] masks;
	
	static {
		// double size so that we don't need to halve index in clearBit
		masks = new int[SIZE << 1];
		for(int index = 0; index < masks.length;index++) {
			// index >> 1 because of not storing even numbers
			masks[index] = 1 << (index >> 1);
		}
	}
	
	public PrimeSieveI32CSearchNextSize(int sieveSize) {
		super(sieveSize);
		dataSet = new int[((sieveSize + 1) >> 1) / SIZE + 1];
	}

	public boolean getBit(int index) {		
		return (dataSet[index >> SHIFT_SIZE_ADD] & masks[index & MOD]) == 0;
	}

	public void clearBit(int index) {
		dataSet[index >> SHIFT_SIZE_ADD] = dataSet[index >> SHIFT_SIZE_ADD] | (masks[index & MOD]);
	}
	
	public void runSieve() {
		int q = (int) Math.sqrt(sieveSize);
		for (int factor = 3; factor <= q; factor += 2) {
			for (int num = factor; num <= sieveSize; num += 2) {
				if (getBit(num)) {
					factor = num;
					break;
				}
			}
			clearBits(factor);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		PrimeSieveBase.run(() -> new PrimeSieveI32CSearchNextSize(1000000), args);
	}
}
