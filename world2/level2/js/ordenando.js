// Função para trocar os valores de duas posições de um vetor
const swap = (arr, i, j) => {
    [arr[i], arr[j]] = [arr[j], arr[i]];
};

// Função para embaralhar os elementos de um vetor
const shuffle = (arr, swaps) => {
    for (let i = 0; i < swaps; i++) {
        let idx1 = Math.floor(Math.random() * arr.length);
        let idx2 = Math.floor(Math.random() * arr.length);
        swap(arr, idx1, idx2);
    }
};

// Função para ordenar um vetor usando o algoritmo Bubble Sort
const bubble_sort = (arr) => {
    let n = arr.length;
    for (let i = 0; i < n - 1; i++) {
        for (let j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
        }
    }
};

// Função para ordenar um vetor usando o algoritmo Selection Sort
const selection_sort = (arr) => {
    let n = arr.length;
    for (let i = 0; i < n - 1; i++) {
        let min_idx = i;
        for (let j = i + 1; j < n; j++) {
            if (arr[j] < arr[min_idx]) {
                min_idx = j;
            }
        }
        swap(arr, i, min_idx);
    }
};

// Função para ordenar um vetor usando o algoritmo Quick Sort
const quick_sort = (arr, low = 0, high = arr.length - 1) => {
    if (low < high) {
        let pivotIdx = partition(arr, low, high);
        quick_sort(arr, low, pivotIdx - 1);
        quick_sort(arr, pivotIdx + 1, high);
    }
};

// Função de particionamento para o Quick Sort
const partition = (arr, low, high) => {
    let pivot = arr[high];
    let i = low - 1;
    for (let j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return i + 1;
};

// Função para adicionar um valor à lista
const add = () => {
    let valor = document.getElementById('valor').value;
    let lista = document.getElementById('valores');
    let node = document.createElement('li');
    node.className = 'list-group-item';
    node.textContent = valor;
    lista.appendChild(node);
    document.getElementById('valor').value = '';
};

// Função para ordenar os valores da lista
const ordenar = () => {
    let lista = document.getElementById('valores');
    let items = Array.from(lista.children);
    let valores = items.map(item => parseInt(item.textContent, 10));

    let algoritmo = document.getElementById('algoritmo').value;
    switch (algoritmo) {
        case 'bubble_sort':
            bubble_sort(valores);
            break;
        case 'selection_sort':
            selection_sort(valores);
            break;
        case 'quick_sort':
            quick_sort(valores);
            break;
    }

    lista.innerHTML = '';
    valores.forEach(valor => {
        let node = document.createElement('li');
        node.className = 'list-group-item';
        node.textContent = valor;
        lista.appendChild(node);
    });
};

// Função para misturar os valores da lista
const misturar = () => {
    let lista = document.getElementById('valores');
    let items = Array.from(lista.children);
    let valores = items.map(item => parseInt(item.textContent, 10));

    shuffle(valores, valores.length * 2);

    lista.innerHTML = '';
    valores.forEach(valor => {
        let node = document.createElement('li');
        node.className = 'list-group-item';
        node.textContent = valor;
        lista.appendChild(node);
    });
};
