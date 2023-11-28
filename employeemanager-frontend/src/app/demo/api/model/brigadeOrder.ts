import { Rank } from './rank';

export interface BrigadeOrder {
    id?: number;
    hui?: string;
    code?: string;
    dutyName?: string;
    ranks?: Rank[];
}
