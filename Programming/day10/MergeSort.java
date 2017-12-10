public class MergeSort<T extends Comparable> implements ISort<T> {
	public void sort(T[] in) {
		T[][] sublists = (T[][]) new Comparable[in.length][1];
		for(int i = 0; i < sublists.length; i++) {
			sublists[i][0] = in[i];
		}

		while(sublists.length > 1) {
			T[][] updated = (T[][]) new Comparable[(sublists.length / 2) + (sublists.length % 2 == 0 ? 0 : 1)][1];

			for(int i = 0; i < updated.length; i++) {
				if(i == updated.length - 1 && sublists.length % 2 != 0) {
					updated[i] = sublists[sublists.length - 1];
					continue;
				}
				updated[i] = merge(sublists[i * 2], sublists[(i * 2) + 1]);
			}

			sublists = updated;
		}

		in = sublists[0];

		/*T previous = in[0];
		for(T element : in) {
			if(element.compareTo(previous) < 0) {
				System.out.println("List is not correctly sorted!");
				return;
			}
			previous = element;
		}

		System.out.println("List is correctly sorted! ");*/
		
	}

	public T[] merge(T[] a, T[] b) {
		// Thank you to Mike Saull on StackOverflow for providing inspiration
		// for a more concise implementation than what I originally came up with!
		T[] merged = (T[]) new Comparable[a.length + b.length];
		
		int i = 0, j = 0, k = 0;

		while(i < a.length && j < b.length) {
			merged[k++] = a[i].compareTo(b[j]) < 0 ? a[i++] : b[j++];
		}

		while(i < a.length) {
			merged[k++] = a[i++];
		}

		while(j < b.length) {
			merged[k++] = b[j++];
		}

		return merged;
	}

	public String sortName() {
		return "Merge Sort";
	}
}
