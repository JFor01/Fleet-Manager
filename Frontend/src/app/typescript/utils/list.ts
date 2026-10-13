import {Indexable} from '../entities/Indexable';

export function updateEntity<T extends Indexable>( item :T,list :T[],):T[]
{
 return list.map(x => x.id == item.id ? item : x)
}
