public class MySecondDataStructure {
	/*
     * You may add any fields that you wish to add.
     * Remember that the use of built-in Java classes is not allowed,
     * the only variables types you can use are: 
     * 	-	the given classes in the assignment
     * 	-	basic arrays
     * 	-	primitive variables
     */

	// בודק יקר, בחרתי ליצור מערך שבכל אינדקס מוחזקת רשימה של מוצרים שהאיכות שלהם זהה למספר האינדקס
	private MyLinkedList<Product>[] lists;
	private int[] qualitiyCount;
	private int totalProducts;
	private int totalQualitySum;
	private Product mostExpensiveProduct;
	
	/***
     * This function is the Init function.
	 * @param N The maximum number of elements in the data structure at each time.
     */
	public MySecondDataStructure(int N) {
		this.lists = new MyLinkedList[6];
		for(int i = 0; i < 6; i++)
			this.lists[i] = new MyLinkedList<>();

		this.qualitiyCount = new int[6];
		this.totalProducts = 0;
		this.totalQualitySum = 0;
		this.mostExpensiveProduct = null;
	}
	
	public void insert(Product product) {
		int q = product.quality();
		ListLink<Product> link = new ListLink<>(product.id(), product);

		lists[q].insert(link);
		qualitiyCount[q] = qualitiyCount[q] + 1;
		totalProducts = totalProducts + 1;
		totalQualitySum = totalQualitySum + q;

		if(mostExpensiveProduct == null || product.price() > mostExpensiveProduct.price())
			mostExpensiveProduct = product;
	}
	
	public void findAndRemove(int id) {
		for(int q = 0; q < 6; q++) {
			ListLink<Product> current = lists[q].head();
			while(current != null) {
				if(current.key() == id) {
					Product product = current.satelliteData();

					//update avg and median
					qualitiyCount[q] = qualitiyCount[q] - 1;
					totalProducts = totalProducts - 1;
					totalQualitySum = totalQualitySum - q;

					//update the mostExpensiveProduct
					if(mostExpensiveProduct != null && mostExpensiveProduct.id() == id) {
						mostExpensiveProduct = null;
						for (int i = 0; i < 6; i++){
							ListLink<Product> scan = lists[i].head();
							while(scan != null) {
								Product p = scan.satelliteData();
								if(mostExpensiveProduct == null || p.price() > mostExpensiveProduct.price())
									mostExpensiveProduct = p;
								scan = scan.getNext();
							}
						}
					}
					lists[q].delete(current);
					return;
				}
				current = current.getNext();
			}
		}
	}
	
	public int medianQuality() {
		int sum = 0;
		int cumulativeQuality = 0;
		for (int i : qualitiyCount)
			sum += i;
		int idx = (sum + 1) / 2;

		for (int i = 0; i < 6; i++) {
			cumulativeQuality += qualitiyCount[i];
			if (cumulativeQuality >= idx)
				return i;
		}
        return 0;
    }

	
	public double avgQuality() {
		double a = totalQualitySum;
		return a / totalProducts;
	}

	public void raisePrice(int raise, int quality) {
		ListLink<Product> current = lists[quality].head();
		while(current != null) {
			Product p = current.satelliteData();
			p.setPrice(p.price() + raise);
			if(p.price() > mostExpensiveProduct.price())
				mostExpensiveProduct = p;
		}
	}

	public Product mostExpensive() {
		return mostExpensiveProduct;
	}

}
