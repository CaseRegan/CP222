public class MergeSort<T extends Comparable> implements ISort<T> {
	public void sort(T[] in) {
		in = mergeSort(in);
	}
	
	public T[] mergeSort(T[] in) {
		if(in.length == 1) { return in; }
		
		T[] front = (T[]) new Comparable[in.length / 2];
		int i = 0;
		while(i < front.length) {
			front[i] = in[i];
			i++;
		}
		T[] back = (T[]) new Comparable[in.length - front.length];
		while(i < in.length) {
			back[i - front.length] = in[i];
			i++;
		}

		front = mergeSort(front);
		back = mergeSort(back);

		return merge(front, back);
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
		return "Recursive Merge Sort";
	}
}
