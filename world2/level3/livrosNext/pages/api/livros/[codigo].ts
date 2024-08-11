import { NextApiRequest, NextApiResponse } from 'next';
import { ControleLivro } from "../../../classes/controle/ControleLivros";

export const controleLivro = new ControleLivro();

const handler = (req: NextApiRequest, res: NextApiResponse) => {
  try {
    if (req.method === 'DELETE') {
      const { codigo } = req.query;
      controleLivro.excluir(Number(codigo));
      res.status(200).json({ message: 'Livro excluído com sucesso' });
    } else {
      res.status(405).send('Método não permitido');
    }
  } catch (error) {
    res.status(500).send('Erro no servidor');
  }
};

export default handler;
