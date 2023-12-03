// variables
const $ = document.querySelector.bind(document)
const $$ = document.querySelectorAll.bind(document)
// data

let dataDrinks = {
  coffee: [
    {
      id: 1,
      name: 'Cà Phê Đen',
      subName: 'Cà Phê',
      price: 19000,
      img: 'resources/img/drink_menu/cafe1.png',
      tag: 1
    },
    {
      id: 2,
      name: 'Cà Phê Sữa',
      subName: 'Cà Phê',
      price: 25000,
      img: 'resources/img/drink_menu/cafe2.png',
      tag: 1
    },
    {
      id: 3,
      name: 'Cà Phê Thường',
      subName: 'Cà Phê',
      price: 17000,
      img: 'resources/img/drink_menu/cafe3.png',
      tag: 1
    },
    {
      id: 4,
      name: 'Cà Phê Phô Mai',
      subName: 'Cà Phê',
      price: 28000,
      img: 'resources/img/drink_menu/cafe4.png',
      tag: 1
    },
    {
      id: 5,
      name: 'Cà Phê Tuyết',
      subName: 'Cà Phê',
      price: 39000,
      img: 'resources/img/drink_menu/cafe5.png',
      tag: 1
    }
  ],

  milkTea: [
    {
      id: 1,
      name: 'Trà Sữa Đường Đen',
      subName: 'Trà sữa',
      price: 25000,
      img: 'resources/img/drink_menu/ts1.png',
      tag: 2
    },

    {
      id: 2,
      name: 'Trà Sữa Matcha',
      subName: 'Trà sữa',
      price: 32000,
      img: 'resources/img/drink_menu/ts2.png',
      tag: 2
    },
    {
      id: 3,
      name: 'Trà Sữa Khoai Môn',
      subName: 'Trà sữa',
      price: 36000,
      img: 'resources/img/drink_menu/ts3.png',
      tag: 2
    },
    {
      id: 4,
      name: 'Trà Sữa Chesse',
      subName: 'Trà sữa',
      price: 33000,
      img: 'resources/img/drink_menu/ts4.png',
      tag: 2
    },
    {
      id: 5,
      name: 'Trà Sữa Ca Cao',
      subName: 'Trà sữa',
      price: 28000,
      img: 'resources/img/drink_menu/ts5.png',
      tag: 2
    }
  ],

  soda: [
    {
      id: 1,
      name: 'Soda Đào',
      subName: 'Soda',
      price: 30000,
      img: 'resources/img/drink_menu/soda1.png',
      tag: 3
    },

    {
      id: 2,
      name: 'Soda Nho',
      subName: 'Soda',
      price: 27000,
      img: 'resources/img/drink_menu/soda2.png',
      tag: 3
    },
    {
      id: 3,
      name: 'Soda Dâu',
      subName: 'Soda',
      price: 36000,
      img: 'resources/img/drink_menu/soda3.png',
      tag: 3
    },
    {
      id: 4,
      name: 'Soda Chanh',
      subName: 'Soda',
      price: 28000,
      img: 'resources/img/drink_menu/soda4.png',
      tag: 3
    },
    {
      id: 5,
      name: 'Soda Ngân Hà',
      subName: 'Soda',
      price: 45000,
      img: 'resources/img/drink_menu/soda5.png',
      tag: 3
    }
  ]
}

let dataCakes = [
  {
    id: 1,
    name: 'Bánh Cuộn Nho Khô',
    subName: 'Bánh ngọt',
    price: 30000,
    img: 'resources/img/cake/banh1.png',
    tag: 4
  },

  {
    id: 2,
    name: 'Bánh Nướng Mè',
    subName: 'Bánh ngọt',
    price: 27000,
    img: 'resources/img/cake/banh2.png',
    tag: 4
  },

  {
    id: 3,
    name: 'Bánh Sừng',
    subName: 'Bánh ngọt',
    price: 20000,
    img: 'resources/img/cake/banh3.png',
    tag: 4
  },

  {
    id: 4,
    name: 'Bánh Mật Ngọt',
    subName: 'Bánh ngọt',
    price: 22000,
    img: 'resources/img/cake/banh4.png',
    tag: 4
  },

  {
    id: 5,
    name: 'Bánh Cuộn Mức Dâu',
    subName: 'Bánh ngọt',
    price: 45000,
    img: 'resources/img/cake/banh5.png',
    tag: 4
  },

  {
    id: 6,
    name: 'Bánh Trứng Muối',
    subName: 'Bánh ngọt',
    price: 32000,
    img: 'resources/img/cake/banh6.png',
    tag: 4
  },

  {
    id: 7,
    name: 'Bánh Quế Mật Ong',
    subName: 'Bánh ngọt',
    price: 36000,
    img: 'resources/img/cake/banh7.png',
    tag: 4
  },

  {
    id: 8,
    name: 'Bánh Trứng Nướng',
    subName: 'Bánh ngọt',
    price: 42000,
    img: 'resources/img/cake/banh8.png',
    tag: 4
  }
]

//navbar
const itemNavBars = $$('.item__navbar')
itemNavBars.forEach(item => {
  item.onclick = function () {
    $('.item__navbar.active').classList.remove('active')
    item.classList.add('active')
  }
})

var paymentTransferRadio = document.getElementById("payment-tranfer");
var paymentAtRadio = document.getElementById("payment-at");
var imageContainer = document.getElementById("image-container");

paymentTransferRadio.addEventListener("click", function () {
  if (this.checked) {
    imageContainer.style.display = "block";
  } else {
    imageContainer.style.display = "none";
  }
});

paymentAtRadio.addEventListener("click", function () {
  if (this.checked) {
    imageContainer.style.display = "none";
  }
});

// cart
const showCart = $('.header__navbar-cart')
const cart = $('.cart')
const btnBack = $('.button__back')
showCart.onclick = function () {
  cart.classList.add('active')
}

btnBack.onclick = function () {
  cart.classList.remove('active')
}

// slide

const imgSpace = $$('.img__space')
let currentSlide = 0

setInterval(function next() {
  currentSlide = (currentSlide + 1) % imgSpace.length
  $('.img__space.active').classList.remove('active')
  imgSpace[currentSlide].classList.add('active')
}, 3000)

function prev() {
  currentSlide = (currentSlide - 1 + imgSpace.length) % imgSpace.length
  $('.img__space.active').classList.remove('active')
  imgSpace[currentSlide].classList.add('active')
}

// render drinks and cakes

function app() {
  renderDrinks()
  renderCake()
}
app()

const itemDrink = $$('.menu__drink-item')
const listDrinks = $$('.list__drink')
itemDrink.forEach((item, index) => {
  let menuDrink = listDrinks[index]
  item.onclick = function () {
    $('.menu__drink-item.active').classList.remove('active')
    item.classList.add('active')

    $('.list__drink.active').classList.remove('active')
    menuDrink.classList.add('active')
  }
})

function renderDrinks() {
  renderDrinkCoffee()
  renderDrinkMilktea()
  renderDrinkSoda()
}

function renderCake() {
  const listCake = $('.list__cake')
  const htmls = dataCakes.map((cake, index) => {
    return `
      <li class="box__item">
          <div class="box__item-img ">
              <img srcset="${cake.img} 3x" alt="img">
          </div>
          <div class="box__item-content ">
              <div class="box__item-info">
                  <div class="item__drink-name ">${cake.name}</div>
                  <div class="item__drink-price ">${convert(cake.price)} đ</div>
              </div>
              <div class="box__item-like">
                  <i class="fa-regular fa-heart icon-liked"></i>
              </div>
          </div>
          <div class="box__item-btn">
              <button class="btn-add" onclick="addToCart(${
                cake.tag
              }, ${index}, ${
      index +
      dataDrinks.coffee.length +
      dataDrinks.milkTea.length +
      dataDrinks.soda.length
    })">
                  Thêm vào giỏ hàng
              </button>
          </div>
    </li>
      `
  })
  listCake.innerHTML = htmls.join('')
}

function renderDrinkCoffee() {
  const listCoffee = $('.list__drink-coffee')
  const htmls = dataDrinks.coffee.map((drink, index) => {
    return renderCoffee(drink, index)
  })
  listCoffee.innerHTML = htmls.join('')
}

function renderDrinkMilktea() {
  const listMilktea = $('.list__drink-milktea')
  const htmls = dataDrinks.milkTea.map((drink, index) => {
    return renderMilktea(drink, index)
  })
  listMilktea.innerHTML = htmls.join('')
}

function renderDrinkSoda() {
  const listMilktea = $('.list__drink-soda')
  const htmls = dataDrinks.soda.map((drink, index) => {
    return renderSoda(drink, index)
  })
  listMilktea.innerHTML = htmls.join('')
}

function renderCoffee(drink, index) {
  return `
    <li class="box__item">
      <div class="box__item-img ">
          <img srcset="${drink.img} 2x" alt="img">
      </div>
      <div class="box__item-content ">
          <div class="box__item-info">
              <div class="item__drink-name ">${drink.name}</div>
              <div class="item__drink-price ">${convert(drink.price)} đ</div>
          </div>
          <div class="box__item-like">
              <i class="fa-regular fa-heart icon-liked"></i>
          </div>
      </div>
      <div class="box__item-btn">
          <button class="btn-add" onclick="addToCart(${drink.tag}, ${index}, ${
    index + 0
  })">
              Thêm vào giỏ hàng
          </button>
      </div>
    </li>
    `
}

function renderMilktea(drink, index) {
  return `
    <li class="box__item">
      <div class="box__item-img ">
          <img srcset="${drink.img} 2x" alt="img">
      </div>
      <div class="box__item-content ">
          <div class="box__item-info">
              <div class="item__drink-name ">${drink.name}</div>
              <div class="item__drink-price ">${convert(drink.price)} đ</div>
          </div>
          <div class="box__item-like">
              <i class="fa-regular fa-heart icon-liked"></i>
          </div>
      </div>
      <div class="box__item-btn">
          <button class="btn-add" onclick="addToCart(${drink.tag}, ${index}, ${
    index + dataDrinks.coffee.length
  })">
              Thêm vào giỏ hàng
          </button>
      </div>
    </li>
    `
}

function renderSoda(drink, index) {
  return `
    <li class="box__item">
      <div class="box__item-img ">
          <img srcset="${drink.img} 2x" alt="img">
      </div>
      <div class="box__item-content ">
          <div class="box__item-info">
              <div class="item__drink-name ">${drink.name}</div>
              <div class="item__drink-price ">${convert(drink.price)} đ</div>
          </div>
          <div class="box__item-like">
              <i class="fa-regular fa-heart icon-liked"></i>
          </div>
      </div>
      <div class="box__item-btn">
          <button class="btn-add" onclick="addToCart(${drink.tag}, ${index}, ${
    index + dataDrinks.coffee.length + dataDrinks.milkTea
  })">
              Thêm vào giỏ hàng
          </button>
      </div>
    </li>
    `
}

// toast

function toast({ message = '', type = 'info', duration = 3000 }) {
  const main = $('#toast')
  if (main) {
    const toast = document.createElement('div')
    const icons = {
      success: 'fa-solid fa-circle-check',
      error: 'fa-solid fa-circle-exclamation'
    }

    const icon = icons[type]
    const delay = (duration / 1000).toFixed(2)
    toast.classList.add('toast', `toast--${type}`)
    toast.style.animation = `slideInRight ease 2s, fadeOut linear 1s ${delay}s forwards`
    toast.innerHTML = `
            <div class="toast__icon">
                <i class="${icon}"></i>
            </div>

            <div class="toast__body">
                <div class="toast__msg">${message}</div>
            </div>

            <div class="toast__close">
                <i class="fa-solid fa-xmark"></i>
            </div>
        `
    main.appendChild(toast)

    setTimeout(function () {
      main.removeChild(toast)
    }, duration + 1000)
  }
}

function showSuccessToast() {
  toast({
    message: 'Bạn đã thêm sản phẩm vào giỏ hàng',
    type: 'success',
    duration: 3000
  })
}

function showErrorToast() {
  toast({
    message: 'Sản phẩm đã tồn tại trong giỏ hàng',
    type: 'error',
    duration: 3000
  })
}

// Add to Cart
let dataList = []
const quanlity = $('.cart__quanlity span.quanlity')
const quanlityOut = $('.quanlity__cart')
const listCart = $('.list__cart')
const resultPrice = $('.cart__total-content')
const totalPrice = $('.content__total-bill')
function addToCart(tag, index, indexList) {
  if (tag == 1) {
    if (dataList[indexList] == null) {
      dataList[indexList] = dataDrinks.coffee[index]
      dataList[indexList].quanlity = 1
      dataList[indexList].ID = indexList
    }
  } else if (tag == 2) {
    if (dataList[indexList] == null) {
      dataList[indexList] = dataDrinks.milkTea[index]
      dataList[indexList].quanlity = 1
      dataList[indexList].ID = indexList
    }
  } else if (tag == 2) {
    if (dataList[indexList] == null) {
      dataList[indexList] = dataDrinks.soda[index]
      dataList[indexList].quanlity = 1
      dataList[indexList].ID = indexList
    }
  } else if (tag == 4) {
    if (dataList[indexList] == null) {
      dataList[indexList] = dataCakes[index]
      dataList[indexList].quanlity = 1
      dataList[indexList].ID = indexList
    }
  }
  showSuccessToast()
  addCart()
}
function settingQuanlity(id, quanlity) {
  dataList[id].quanlity = quanlity
  if (quanlity <= 0) {
    delete dataList[id]
    addCart()
  }
  addCart()
}

function addCart() {
  listCart.innerHTML = ''
  let count = 0
  let total = 0
  let result = 0
  totalPrice.innerHTML = 0 + 'VND'
  resultPrice.innerHTML = 0 + 'VND'
  quanlityOut.innerHTML = 0
  quanlity.innerHTML = 0

  dataList.forEach((item, index) => {
    if (item != null) {
      count += item.quanlity
      total += item.price * item.quanlity
      result = total + 15000
      let newDiv = document.createElement('div')
      newDiv.classList.add('item__cart')
      newDiv.innerHTML = `
        <div class="item__cart-content">
            <div class="item__cart-img">
                <img srcset="${item.img} 2x" alt="">
            </div>
            <div class="item__cart-info">
                <div class="cart__info-name">${item.name}</div>
                <div class="cart__info-subname">${item.subName}</div>
                <div class="cart__info-price">${convert(item.price)} VND</div>
            </div>
        </div>
        <div class="setting__quanlity">
            <div class="setting__quanlity-btn">
                <button class="button__quanlity-down" onclick="settingQuanlity(${
                  item.ID
                }, ${item.quanlity - 1})">-</button>
                <div class="number__quanlity">${item.quanlity}</div>
                <button class="button__quanlity-up" onclick="settingQuanlity(${
                  item.ID
                }, ${item.quanlity + 1})">+</button>
            </div>

            <div class="setting__quanlity-remove">
                <button class="btn__remove" onclick="removeCart(${
                  item.ID
                })">Xóa</button>
            </div>
        </div>
      `
      listCart.appendChild(newDiv)
    }
    totalPrice.innerHTML = convert(total) + ' VNĐ'
    resultPrice.innerHTML = convert(result) + ' VNĐ'
    quanlity.innerHTML = count
    quanlityOut.innerHTML = count
  })
}

const buyBtn = $('.button__buy')
const cart1 = $('.cart')
const form = $('.form__address')
const subform = $('.form')
const btnCloseForm = $('.btn-close')
buyBtn.onclick = function () {
  form.classList.add('active')
  cart1.classList.remove('active')
}

btnCloseForm.onclick = function () {
  form.classList.remove('active')
}

form.onclick = function () {
  form.classList.remove('active')
}

subform.onclick = function () {
  event.stopPropagation()
}

function removeCart(id) {
  delete dataList[id]
  addCart()
}

function convert(number) {
  let vnd = number.toLocaleString('eng')
  vnd = vnd.replace('.', ',')
  return vnd
}
