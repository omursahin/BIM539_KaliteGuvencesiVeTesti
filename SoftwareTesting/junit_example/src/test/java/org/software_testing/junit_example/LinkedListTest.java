package org.software_testing.junit_example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class LinkedListTest {



	@Mock
	LinkedList<Integer> mockedLinkedList = Mockito.mock(LinkedList.class);

	@Before
	public void setUp() throws Exception {
		// Eger mock kulalniyorsaniz buna ihtiyaciniz var
		MockitoAnnotations.initMocks(mockedLinkedList);

	}

	@After
	public void tearDown() throws Exception {
		// ihtiyac varsa kullanin, burada gerek yok
	}


	// --------------------------------------------------------------
	// 0 uzunlukta testler
	// --------------------------------------------------------------

	// Test: 0 uzunlukta bir listeniz varsa ve ilk elemana ulasmak istiyorsaniz null donmeli
	// ilk eleman
	@Test
	public void testZeroList() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.clear();
		assertNull(ll.getFront());
	}

	// Test: .clear() metodunun dogru calisip calismadigini kontrol eder. Basta bir eleman ekler ve daha sonra
	// bu elemani siler
	// Liste bunun sonunda bos olmalidir (bos olup olmadigi ilk elemanin null olup olmadiginin kontrolu ile
	//yapilmistir).

	@Test
	public void testClearedList() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.addToFront(new Node<Integer>(new Integer(7)));
		ll.clear();
		assertNull(ll.getFront());
	}

	// Bu test birden fazla elemanli listede clear metodunu test eder

	@Test
	public void testMultiList() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int j=0; j < 10; j++) {
			ll.addToFront(new Node<Integer>(new Integer(j)));
		}
		ll.clear();
		assertNull(ll.getFront());
	}

	// --------------------------------------------------------------
	// ADD TO FRONT Testi
	// --------------------------------------------------------------

	// 10 dugum ekledikten sonra 1 dugum daha ekle. Dah sonra setNext()'in ilk 10 dugumun sonuncusu olarak ayarladiktan sonra
	// testNode'un liste basindaki dugume ayni olup olmadiginin testi

	@SuppressWarnings("unchecked")
	@Test
	public void testAddToTenItemLL() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Node<Integer>[] nodes = new Node[10];

		for (int j = 0; j < 10; j++) {
			nodes[j] = Mockito.mock(Node.class);
			ll.addToFront(nodes[j]);
		}

		Node<Integer> testNode = Mockito.mock(Node.class);
		ll.addToFront(testNode);
		Mockito.verify(testNode).setNext(Matchers.eq(nodes[9]));
		assertSame(ll.getFront(), testNode);

	}

	// Once bir dugum ekle sonra ardindan bir daha (testNode).  Daha sonra orijinal düğüme setNext()'in çağrıldığını ve eklenen testNode düğümünün listenin başındakiyle aynı olup olmadığını kontrol edin.

	@SuppressWarnings("unchecked")
	@Test
	public void testAddToOneItemLL() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Node<Integer> existingNode = Mockito.mock(Node.class);
		Node<Integer> testNode = Mockito.mock(Node.class);
		ll.addToFront(existingNode);
		ll.addToFront(testNode);
		Mockito.verify(testNode).setNext(Matchers.eq(existingNode));
		assertSame(ll.getFront(), testNode);
	}

	//  addToFront()'a null deger verilince IllegalArgumentException firlatma testi
	@Test
	public void testAddNullToNoItemLL() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		try {
			ll.addToFront(null);
			fail("Adding a null node should result in an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
	}

	// --------------------------------------------------------------
	// Silme testi
	// --------------------------------------------------------------

	// Bos listede hata firlatmadan eleman silme kontrolu

	@Test
	public void testDeleteFrontNoItem() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.deleteFront();
		assertEquals(ll.getFront(), null);

	}

	// Tek elemanli listede hata firlatmadan eleman silme testi, sonuc olarak bos bir
	//LinkedList bulunacaktir.

	@SuppressWarnings("unchecked")
	@Test
	public void testDeleteFrontOneItem() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.addToFront(Mockito.mock(Node.class));
		ll.deleteFront();
		assertEquals(ll.getFront(), null);
	}

	// Cok elemanli listede Front silme testi

	@SuppressWarnings("unchecked")
	@Test
	public void testDeleteFrontMultipleItems() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Node<Integer>[] nodes = new Node[10];

		for (int j = 0; j < 10; j++) {
			nodes[j] = new Node<Integer>(new Integer(1));
			ll.addToFront(nodes[j]);
		}

		ll.deleteFront();

		assertSame(ll.getFront(), nodes[8]);
	}

	// --------------------------------------------------------------
	// ESITLIK TESTLERI
	// --------------------------------------------------------------

	//  Bir bagli listenin kendine esitligi testi.
	@Test
	public void testEqualsSelf() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		assertEquals(ll, ll);
	}

	//	Elemansiz iki LL'in birbirine esitligi testi.
	@Test
	public void testEquals0Elems() {
		LinkedList<Integer> ll01 = new LinkedList<Integer>();
		LinkedList<Integer> ll02 = new LinkedList<Integer>();
		assertEquals(ll01, ll02);
	}

	//	Orneklenmis bir bagli liste null olmama kontrolu.
	@Test
	public void testNotEqualsNull() {
		LinkedList<Integer> ll01 = new LinkedList<Integer>();
		assertFalse(ll01.equals(null));
	}

	//  LL, LL olmayan nesneye esit mi testi
	@Test
	public void testNotEqualsRegularObject() {
		LinkedList<Integer> ll01 = new LinkedList<Integer>();
		Object obj = new Object();
		assertFalse(ll01.equals(obj));
	}


	//  Ayni degere sahip tek dugumlu iki listenin esitligi
	@Test
	public void testEqualsOneNodeSameVals() {
		LinkedList<Integer> ll11 = new LinkedList<Integer>();
		LinkedList<Integer> ll12 = new LinkedList<Integer>();
		ll11.addToFront(new Node<Integer>(new Integer(1)));
		ll12.addToFront(new Node<Integer>(new Integer(1)));
		assertEquals(ll11, ll12);
	}

	//  Farklı degere sahip tek dugumlu iki listenin esit olmamasi kontrolu
	@Test
	public void testEqualsOneNodeDiffVals() {
		LinkedList<Integer> ll11 = new LinkedList<Integer>();
		LinkedList<Integer> ll2 = new LinkedList<Integer>();
		ll11.addToFront(new Node<Integer>(new Integer(1)));
		ll2.addToFront(new Node<Integer>(new Integer(2)));
		assertFalse(ll11.equals(ll2));
	}

	//  farkli boyutlarda ayni elemana sahip iki LL'in esit olmamasi kontrolu
	@Test
	public void testNotEqualsDiffSizes() {
		LinkedList<Integer> ll11 = new LinkedList<Integer>();
		LinkedList<Integer> ll_3elems = new LinkedList<Integer>();

		ll11.addToFront(new Node<Integer>(new Integer(1)));
		ll_3elems.addToFront(new Node<Integer>(new Integer(3)));
		ll_3elems.addToFront(new Node<Integer>(new Integer(2)));
		ll_3elems.addToFront(new Node<Integer>(new Integer(1)));

		assertFalse(ll_3elems.equals(ll11));
	}

	// Ayni referansa sahip iki LL'in esitligi
	@Test
	public void testEqualsRef() {
		LinkedList<Integer> ll11 = new LinkedList<Integer>();
		ll11.addToFront(new Node<Integer>(new Integer(1)));
		LinkedList<Integer> ll11_new = ll11;
		assertSame(ll11, ll11_new);
	}

	// Ayni boyutta ancak farklı veride listelerin esit olmamasi testi
	@Test
	public void testNotEqualsDiffData() {
		LinkedList<Integer> ll_3elems = new LinkedList<Integer>();
		LinkedList<Integer> ll_321 = new LinkedList<Integer>();
		ll_3elems.addToFront(new Node<Integer>(new Integer(3)));
		ll_3elems.addToFront(new Node<Integer>(new Integer(2)));
		ll_3elems.addToFront(new Node<Integer>(new Integer(1)));

		ll_321.addToFront(new Node<Integer>(new Integer(1)));
		ll_321.addToFront(new Node<Integer>(new Integer(2)));
		ll_321.addToFront(new Node<Integer>(new Integer(3)));
		assertFalse(ll_321.equals(ll_3elems));
	}

	//  Coklu dugumlu ve ayni degerlere sahip LL'lerin esit olmasi testi
	@Test
	public void testEqualsSameData() {
		LinkedList<Integer> ll_321 = new LinkedList<Integer>();
		LinkedList<Integer> ll_321_2 = new LinkedList<Integer>();

		ll_321.addToFront(new Node<Integer>(new Integer(1)));
		ll_321.addToFront(new Node<Integer>(new Integer(2)));
		ll_321.addToFront(new Node<Integer>(new Integer(3)));

		ll_321_2.addToFront(new Node<Integer>(new Integer(1)));
		ll_321_2.addToFront(new Node<Integer>(new Integer(2)));
		ll_321_2.addToFront(new Node<Integer>(new Integer(3)));

		assertTrue(ll_321.equals(ll_321_2));

	}

}