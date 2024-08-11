import React, { useEffect, useState } from 'react';
import { NextApiRequest, NextApiResponse } from "next";
import { ControleEditora } from "../../../classes/controle/ControleEditora";

export const controleEditora = new ControleEditora();

const handler = (req: NextApiRequest, res: NextApiResponse) => {
    try {
        if (req.method === 'GET') {
            const editoras = controleEditora.getEditoras();
            res.status(200).json(editoras);
        } else {
            res.status(405).send('Método não permitido');
        }
    } catch (error) {
        res.status(500).send('Erro no servidor');
    }
};

export default handler;
