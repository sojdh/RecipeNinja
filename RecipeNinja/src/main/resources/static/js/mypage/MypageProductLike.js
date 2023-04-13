$(function() {
	// 전체선택 체크박스 클릭 시
	$('.selectAll-checkbox').click(function() {
		if ($(this).is(':checked')) {
			$('.product-checkbox').prop('checked', true);
		} else {
			$('.product-checkbox').prop('checked', false);
		}
	});
});
function deleteSelectedItems() {
	const checkboxes = document.querySelectorAll('.product-checkbox');
	const selectedItems = [];

	for (let i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			const item = checkboxes[i].closest('.product-item');
			selectedItems.push(item);
		}
	}

	if (selectedItems.length === 0) {
		alert('선택된 상품이 없습니다.');
		return;
	}

	if (confirm(`${selectedItems.length}개의 상품을 삭제하시겠습니까?`)) {
		for (let i = 0; i < selectedItems.length; i++) {
			const item = selectedItems[i];
			item.remove();
		}
	}
}

// 현재 URL을 가져옵니다.
const currentUrl = window.location.href;
// 링크 요소를 가져옵니다.
const link = document.querySelector('.menu-10');

// 링크의 href 속성과 현재 URL을 비교합니다.
if (link && link.href === currentUrl) {
  // 같을 경우 텍스트의 색을 바꿉니다.
  link.style.color = 'red';
}