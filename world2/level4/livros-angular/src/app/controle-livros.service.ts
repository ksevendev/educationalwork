import { Injectable } from '@angular/core';
import { Livro } from './livro';

@Injectable({
    providedIn: 'root',
})
export class ControleLivrosService {
    private livros: Array<Livro> = [
        // Exemplo de livros para início
    ];

    obterLivros(): Array<Livro> {
        return this.livros;
    }

    incluir(livro: Livro): void {
        livro.codigo = this.livros.length + 1;
        this.livros.push(livro);
    }

    excluir(codigo: number): void {
        const index = this.livros.findIndex(livro => livro.codigo === codigo);
        if (index >= 0) {
            this.livros.splice(index, 1);
        }
    }
}
